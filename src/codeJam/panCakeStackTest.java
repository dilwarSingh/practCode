package codeJam;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class panCakeStackTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            int r = s.nextInt();
            int h = s.nextInt();
            System.out.print(r + " <-> " + h + " = ");
            System.out.println(formula(r, h));

        }


    }

    private static float formula(int r, int h) {
        return (float) (Math.PI * r * (r + 2 * h));
    }

}
