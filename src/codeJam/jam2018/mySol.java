package codeJam.jam2018;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class mySol {

    private static List<Character> chars;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            long d = s.nextInt();
            String str = s.next();
            //      char[] chars = str.toCharArray();

            chars = str.chars()
                    .mapToObj(e -> (char) e).collect(Collectors.toList());

            System.out.print("Case #" + (i + 1) + ": ");
            System.out.println(checkStr(d));
        }


    }

    private static String checkStr(long d) {
        int swaps = 0;
        long gunPower = totalGunPower();
        if (gunPower <= d) return "0";

        for (int i = 0; i < chars.size(); i++) {
            int x = checkSwwaping();
            if (x > -1) {
                swap(x, x + 1);
                swaps++;
            }
            long gp = totalGunPower();
            if (gp <= d) return swaps + "";
            else if (x == -1) break;

        }

        return "IMPOSSIBLE";
    }

    private static int checkSwwaping() {
        if (chars.get(chars.size() - 1) == '0') chars.remove(chars.size() - 1);

        for (int i = chars.size() - 2; i >= 0; i--) {
            Character c = chars.get(i);
            if (c == 'C') return i;
        }


        return -1;
    }

    private static void swap(int i, int j) {
        char temp = chars.get(i);
        chars.set(i, chars.get(j));
        chars.set(j, temp);
    }

    private static long totalGunPower() {
        int gunCharge = 1;
        long maxPower = 0;
        for (Character aChar : chars) {
            if (aChar == 'C') gunCharge = gunCharge != 0 ? gunCharge * 2 : 1;
            else maxPower += gunCharge;
        }
        return maxPower;

    }


}
