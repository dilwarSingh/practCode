package codeJam;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class pancakes {


    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedInputStream(System.in));

        int t = s.nextInt();

        for (int i = 1; i <= t; i++) {
            String pan = s.next();
            int flips = s.nextInt();
            Pancakes p = new Pancakes(flips, pan);


            System.out.println("Case #" + i + ": " + p.execute());
        }


    }


    static class Pancakes {
        int flipSize;
        ArrayList<Boolean> pancakesSides;


        Pancakes(int flipSize, String s) {
            this.flipSize = flipSize;
            char[] chars = s.toCharArray();

            this.pancakesSides = new ArrayList<>(chars.length);
            for (char aChar : chars) pancakesSides.add(aChar == '+');

        }

        String execute() {
            int flips = 0;
            for (int i = 0; i <= pancakesSides.size() - flipSize; ) {
                List<Boolean> subList = pancakesSides.subList(i, i + flipSize);
                int v = checkSubList(i, subList);
                if (v > -1) {
                    i = v;
                    flips++;

                    if ((i + flipSize) > pancakesSides.size()) {
                        i++;
                        continue;
                    }

                    for (int j = i; j < i + flipSize; j++) {
                        Boolean b = pancakesSides.get(j);
                        pancakesSides.set(j, !b);
                    }

                } else {
                    i += flipSize;
                }
            }


            if (isDataCorrect()) {
                return "" + flips;
            } else {
                return "IMPOSSIBLE";
            }


        }

        private boolean isDataCorrect() {

            for (Boolean b : pancakesSides) {
                if (!b) return false;
            }
            return true;

        }

        private int checkSubList(int x, List<Boolean> subList) {
            for (int i = 0; i < subList.size(); i++) {
                Boolean b = subList.get(i);
                if (!b) return i + x;
            }
            return -1;

        }


    }
}