package codeJam;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class diceStraight {
    private static final int FACE_COUNT = 6;

    public static void main(String[] args) {
        Scanner inp = new Scanner(new BufferedInputStream(System.in));

        int T = inp.nextInt();

        for (int i = 0; i < T; i++) {
            int x = inp.nextInt();
            int arr[][] = new int[x][6];
            for (int j = 0; j < x; j++) {
                for (int k = 0; k < 6; k++) {
                    arr[j][k] = inp.nextInt();
                }
            }
            findMaxUnits(x, arr);
        }
    }

    private static void findMaxUnits(int x, int[][] arr) {
    }


    public static class Die {

        int id;
        int[] values = new int[FACE_COUNT];

        public Die(int id) {
            this.id = id;
        }

        DieValue valueUsing;
    }

    public static class DieValue {
        int value;
        List<Die> dice;

        public DieValue(int value, List<Die> dice) {
            this.value = value;
            this.dice = dice;
        }

        Die findUnusedDie() {
            for (Die die : dice) {
                if (die.valueUsing == null) return die;
            }
            return null;
        }

        void assignDie() {
            for (Die die : dice) {
                if (die.valueUsing != null) return;
            }
            dice.get(0).valueUsing = this;
        }

        void unassignDie() {
            for (Die die : dice) {
                if (die.valueUsing == this) {
                    die.valueUsing = null;
                    break;
                }
            }
        }

    }

    private static class Test {
        List<Die> dice = new ArrayList<>();
        List<DieValue> dieValues; // Set of distinct values on the face of all dice, sorted by value
        Set<Die> diceVisitedWhileShuffling; // To skip already visited dice when recursively shuffling

        /**
         * Populates the dieValues list from the list of dice.
         */
        void prepareValues() {
            // We don't have particular memory constrains, let's abuse a TreeMap to get sorted unique values
            Map<Integer, List<Die>> valueMap = new TreeMap<>();
            for (Die die : dice) {
                for (int v : die.values) {
                    List<Die> ds = valueMap.get(v);
                    if (ds == null) valueMap.put(v, new ArrayList<>(Arrays.asList(die)));
                    else ds.add(die);
                }
            }
            // But an ArrayList is much better for iteration later
            dieValues = new ArrayList<>(valueMap.size());
            valueMap.forEach((v, ds) -> dieValues.add(new DieValue(v, ds)));
        }

        /**
         * Attempt to recursively free a die by selecting a different die for the same value.
         *
         * @return true if the die has been freed, false if no other die can be found.
         */
        boolean freeByShuffling(Die die) {
            assert die.valueUsing != null;
            // First check if we can just use another dice for the previous value
            for (Die otherDie : die.valueUsing.dice) {
                if (otherDie.valueUsing == null) {
                    otherDie.valueUsing = die.valueUsing;
                    die.valueUsing = null;
                    return true;
                }
            }
            // Nope, we must free a die recursively
            diceVisitedWhileShuffling.add(die);
            for (Die otherDie : die.valueUsing.dice) {
                if (diceVisitedWhileShuffling.contains(otherDie)) continue;
                if (freeByShuffling(otherDie)) {
                    otherDie.valueUsing = die.valueUsing;
                    die.valueUsing = null;
                    return true;
                }
            }
            return false;
        }

        /**
         * Attempt to find an unused die for the specified value by possibly shuffling other already used dice.
         *
         * @return A now-unused die, or null if no shuffling results in an unused die.
         */
        Die findUnusedByShuffling(DieValue dv) {
            diceVisitedWhileShuffling = new HashSet<>();
            for (Die die : dv.dice) {
                if (freeByShuffling(die)) return die;
            }
            return null;
        }

        /**
         * Finds the maximum length of dice with consecutive values.
         */
        int findLongestStraight() {
            int maxLength = 1;
            int endIndex = 0;
            for (int beginIndex = 0; beginIndex < dieValues.size() - 1; ) {
                DieValue dv = dieValues.get(beginIndex);
                debugPrint("  Sequence starting from #" + beginIndex + ": " + dv.value + "... ");
                dv.assignDie();
                int beginValue = dieValues.get(beginIndex).value;
                int maxPossibleLength = Math.min(dieValues.size() - beginIndex, dice.size());
                int nextBeginIndex = beginIndex + 1;
                if (endIndex <= beginIndex) endIndex = beginIndex + 1;
                while (endIndex < dieValues.size()) {
                    dv = dieValues.get(endIndex);
                    debugPrint("    Comparing against #" + endIndex + ": " + dv.value + "... ");
                    if (dv.value != beginValue + endIndex - beginIndex) {
                        // Not a consecutive value, restart scanning from there
                        nextBeginIndex = endIndex;
                        break;
                    }
                    Die die = dv.findUnusedDie();
                    if (die == null) die = findUnusedByShuffling(dv);
                    if (die == null) break;
                    die.valueUsing = dv;
                    endIndex++;
                    if (endIndex - beginIndex > maxLength) maxLength = endIndex - beginIndex;
                    if (maxLength == maxPossibleLength) break;
                }
                debugPrint("length " + (endIndex - beginIndex) + " max " + maxLength);
                if (maxLength == maxPossibleLength) break;
                // The old values at the beginning are no longer useful, free their dice
                for (; beginIndex < nextBeginIndex; beginIndex++) {
                    dieValues.get(beginIndex).unassignDie();
                }
            }
            return maxLength;
        }

        void print() {
            if (DEBUG) {
                for (DieValue dv : dieValues) {
                    System.out.print(dv.value);
                    for (Die die : dv.dice) {
                        System.out.print("\t" + die.id);
                    }
                    System.out.println();
                }
            }
        }
    }

    private static final boolean DEBUG = false;
    private final List<Test> tests = new ArrayList<>();

    private static void debugPrint(String s) {
        if (DEBUG) System.out.println(s);
    }

    private void scanTests(InputStream is) {
        try (Scanner scanner = new Scanner(is)) {
            int testCount = scanner.nextInt();
            for (int t = 0; t < testCount; t++) {
                Test test = new Test();
                int dieCount = scanner.nextInt();
                for (int d = 0; d < dieCount; d++) {
                    Die die = new Die(d + 1);
                    for (int i = 0; i < FACE_COUNT; i++) {
                        int faceValue = scanner.nextInt();
                        die.values[i] = faceValue;
                    }
                    test.dice.add(die);
                }
                tests.add(test);
            }
        }
    }

    private void runTests() {
        int caseIndex = 1;
        for (Test test : tests) {
            test.prepareValues();
            test.print();
            debugPrint("Case #" + caseIndex + " has " + test.dice.size() + " dice and " + test.dieValues.size() + " values.");
            int length = test.findLongestStraight();
            System.out.println("Case #" + caseIndex + ": " + length);
            caseIndex++;
        }
    }
}
