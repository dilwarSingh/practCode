package codeJam;

import java.util.Arrays;
import java.util.Scanner;

public class specialDice {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + " :");
            TestClass tc = new TestClass();
            int x = s.nextInt();
            DiceSet set = new DiceSet(x);
            for (int j = 0; j < x; j++) {
                int arr[] = new int[6];
                for (int k = 0; k < 6; k++) {
                    arr[k] = s.nextInt();
                }
                Dice dice = new Dice(arr);
                set.setDice(j, dice);
            }
            tc.setDiceSet(set);
            tc.execute();

        }


    }


    static class TestClass {
        DiceSet set;

        void setDiceSet(DiceSet set) {
            this.set = set;
        }

        void execute() {

            for (int i = 0; i < set.diceSet.length; i++) {
                Dice dice1 = set.diceSet[i];
                for (int j = i + 1; j < set.diceSet.length; j++) {
                    Dice dice2 = set.diceSet[j];

                }
            }


        }

    }

    class dicePair {
        int min;
        int max;

        public dicePair(int no) {
            this.min = no;
            this.max = no;
        }


        public boolean matcher(int no) {
            if (min - 1 == no) return true;
            else return max + 1 == no;
        }

        void setNo(int no) {
            if (min - 1 == no) min = no;
            else max = no;
        }

    }

    static class DiceSet {
        Dice diceSet[];

        public DiceSet(int totalDice) {
            diceSet = new Dice[totalDice];
        }

        public void setDice(int id, Dice dice) {
            diceSet[id] = dice;
        }
    }

    static class Dice {
        int faces[];

        public Dice(int[] faces) {
            Arrays.sort(faces);
            this.faces = faces;
        }

     /*   boolean findNo(Dice dice) {

          *//*  for (int i = 0; i <; i++) {

            }*//*
        }*/
    }
}