package codeinGame;

import java.math.BigInteger;
import java.util.Scanner;

public class longint {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String N = in.nextLine();


        BigInteger bigInt = new BigInteger(N);

        if (bigInt.remainder(new BigInteger("4")).equals(0)) System.out.println("AAAAAAAAAA!!!");
        else System.out.println("Ok");


    }
}
