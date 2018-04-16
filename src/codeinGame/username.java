package codeinGame;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class username {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String u = in.nextLine();

        if (u.length() < 3 || u.length() > 20) {
            System.out.println("INVALID");
            return;
        }
        String patten = "^[A-Za-z0-9]*$";

        Pattern pattern = Pattern.compile(patten);
        Matcher matcher = pattern.matcher(u);
        if (matcher.matches()) {
            System.out.println("VALID");

        } else {
            System.out.println("INVALID");

        }


    }
}
