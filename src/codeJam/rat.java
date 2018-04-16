package codeJam;

import java.util.Scanner;

public class rat {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int r = s.nextInt();
            int c = s.nextInt();

            NeedKit need[] = new NeedKit[r];
            int qty[][] = new int[r][c];

            for (int j = 0; j < r; j++) need[j] = new NeedKit(s.nextInt());

            for (int j = 0; j < r; j++)
                for (int k = 0; k < c; k++) qty[j][k] = s.nextInt();

            compute(need, qty, c);

        }


    }

    private static void compute(NeedKit[] need, int[][] qty, int c) {


        for (int i = 0; i < need.length; i++) {
            NeedKit nead = need[i];//50
            boolean x = false;
            int j = 0;
            for (j = 0; ; j++) {
                int n = qty[j][i];//450




            }
        }


    }


    static class NeedKit {
        int actual;
        int min;
        int max;

        public NeedKit(int value) {
            this.actual = value;

            int x = value / 10;
            this.min = actual - x;
            this.max = actual + x;
        }
    }


}
