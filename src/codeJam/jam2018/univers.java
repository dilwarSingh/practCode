package codeJam.jam2018;

import java.util.Scanner;

public class univers {
    static boolean change(String sa) {

        char s[] = sa.toCharArray();
        for (int i = s.length - 1; i > 0; --i) {
            if (s[i] == 'S' && s[i - 1] == 'C') {

                char c = s[i];
                s[i] = s[i - 1];
                s[i - 1] = c;

                return true;
            }
        }
        return false;
    }

    static int calDamage(String sa) {
        int r = 0;
        int d = 1;

        char s[] = sa.toCharArray();
        for (int i = 0; i < s.length; ++i) {
            if (s[i] == 'S')
                r += d;
            else
                d *= 2;
        }
        return r;
    }

    static int minimumSteps(String s, int d) {
        int r = 0;
        int damage = calDamage(s);
        while (damage > d) {
            boolean success = change(s);
            if (!success)
                return -1;
            damage = calDamage(s);
            r++;
        }
        return r;
    }

    public static void main(String[] args) {


        Scanner sa = new Scanner(System.in);
        int T = sa.nextInt();

        for (int t = 0; t < T; ++t) {
            int d = sa.nextInt();
            String s = sa.next();


            System.out.println("Case #" + (t + 1) + ": ");
            int result = minimumSteps(s, d);
            if (result < 0)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(result);
        }
    }
}
