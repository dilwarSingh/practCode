package codeinGame;

import java.util.Scanner;

public class dimond {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.print("#");
        }
        System.out.println();

        for (int i = 1; i <= N; i++) {
            for (int j = i; j < N ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        for (int i = 0; i <N; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (N-i) * 2 - 1; j++) {
                System.out.print("#");
            }
            System.out.println();
        }


    }
}
