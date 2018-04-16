package codeJam;

import java.util.Scanner;

public class tindy {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            long d = scanner.nextLong();
            short[] shorts = toArray(d);

            System.out.println("Case #" + i + ": " + compute(shorts));

        }

    }

    private static short[] toArray(long d) {

        String s = d + "";

        char[] chars = s.toCharArray();
        short[] arr = new short[chars.length];

        for (int j = 0; j < chars.length; j++) {
            arr[j] = Short.parseShort(chars[j] + "");
        }
        return arr;

    }


    private static long compute(short[] arr) {


        for (int i = 0; i < arr.length - 1; i++) {

            short now = arr[i];
            short next = arr[i + 1];

            if (now > next) {
                arr[i] = (short) (now - 1);
                for (int j = i + 1; j < arr.length; j++) arr[j] = 9;
                return compute(arr);
            }
        }
        return arrtoLong(arr);

    }

    private static long arrtoLong(short[] arr) {
        String s = "";
        for (short i : arr) s += i;
        return Long.parseLong(s);

    }
}
