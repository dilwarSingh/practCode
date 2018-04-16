package codeinGame;

import java.util.Scanner;

public class Digonal {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            String line = in.next();
            arr[i] = line;
        }

        String word1 = "", word2 = "";


        for (int i = 0; i < N; i++) {
            word1 += arr[i].charAt(i);
        }
        for (int i = 0; i < N; i++) {
            word2 += arr[i].charAt(N - i - 1);
        }


        System.out.println(word1 + " " + word2);
    }


}
