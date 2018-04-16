package codeinGame;

import java.util.Scanner;

public class encr {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String A = in.nextLine();
        String str = "";

        char[] chars = A.toCharArray();

        boolean left = true;
        int l = 0;
        int r = chars.length - 1;


        for (int i = 0; i < chars.length; i++) {
            if (left) {
                left = false;
                str += chars[l];
                l++;
            } else {
                left = true;
                str += chars[r];
                r--;
            }
        }
        System.out.println(str);

    }
}
