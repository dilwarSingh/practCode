package codeinGame;

import java.util.Scanner;

public class square {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (i == 0 || i == (N - 1)) System.out.print("#");
                else {
                    if (j == 0 || j == (N - 1)) System.out.print("#");
                    else System.out.print(" ");
                }
                System.out.println();
            }


        }
    }
}
