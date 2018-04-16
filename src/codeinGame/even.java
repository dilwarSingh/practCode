package codeinGame;

import java.util.Scanner;

public class even {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();

        String s = N + "";
        int result = 0;

        char[] chars = s.toCharArray();

        for (char aChar : chars) {

            int a = Integer.parseInt(aChar + "");

            if (a % 2 == 0) result += a;


        }
        System.out.println(result);

    }
}
