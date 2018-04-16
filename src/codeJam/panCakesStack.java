package codeJam;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class panCakesStack {

    static List<Cakes> list;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            int n = s.nextInt();
            int k = s.nextInt();
            list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) list.add(new Cakes(s.nextInt(), s.nextInt()));
            Collections.sort(list, (o1, o2) -> (int) (o2.exposedArea() - o1.exposedArea()));

            findSol(k);

        }
    }

    private static void findSol(int k) {

        double result = 0D;
        ArrayList<Cakes> subList = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            Cakes cake = list.get(i);
            subList.add(cake);
            result += cake.heightArea();
        }
        Collections.sort(subList, (o1, o2) -> o2.radius - o1.radius);
        result += subList.get(0).Area();

      /*  DecimalFormat df = new DecimalFormat("#.#########");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
       System.out.println(df.format(result)); */
        System.out.println(result);
    }

    static class Cakes {
        int radius;
        int height;

        public Cakes(int radius, int height) {
            this.radius = radius;
            this.height = height;
        }


        public double heightArea() {
            return CircumFrens() * height;
        }

        public double CircumFrens() {
            return 2 * Math.PI * radius;
        }

        public double Area() {
            return Math.PI * Math.pow(radius, 2);
        }

        public double exposedArea() {
            return Area() + heightArea();
        }


    }

}
