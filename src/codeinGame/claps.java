package codeinGame;

import java.util.Scanner;

public class claps {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int claps = 0;
        for (int i = 1; i <= N; i++) {
            int x = i;

            if (x % 7 == 0) claps++;
            else if (clap(x + "")) {
                claps++;
            }


        }


        System.out.println(claps);
    }

    private static boolean clap(String x) {

        char[] chars = x.toCharArray();

        int total = 0;
        for (char aChar : chars) {
            int i = Integer.parseInt(aChar + "");
            if (i == 7) return true;
            total += i;
        }

        return total % 7 == 0;


    }

}

