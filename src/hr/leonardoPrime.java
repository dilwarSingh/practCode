package hr;

import java.util.*;

public class leonardoPrime {

    static Map<Integer, Long> primes = new TreeMap<>();
    static int[] primeNos = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};


    private static void createPrimes() {

        primes.put(primeNos[0], (long) primeNos[0]);
        for (int i = 1; i < primeNos.length; i++) {
            Long dig = primes.get(primeNos[i - 1]) * primeNos[i];
            dig = Math.abs(dig);

            primes.put(primeNos[i], dig);
        }

    }


    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        createPrimes();
        int t = inp.nextInt();

        for (int i = 0; i < t; i++) {
            long no = inp.nextLong();
            System.out.println(find_no(no));
        }
    }

    private static int find_no(long no) {
        if (no == 1) {
            return 0;
        }
        return findPrimeLocation(no);
    }

    private static int findPrimeLocation(long no) {
        for (int i = 0; i < primeNos.length; i++) {
            if (no == primes.get(primeNos[i])) {
                return i+1;
            } else if (no < primes.get(primeNos[i])) {
                return i ;
            }
        }
        return 0;
    }
}
