package codeJam;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class bathrooms {

    static PriorityQueue<lrClass> que = new PriorityQueue<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {
            long stalls = scanner.nextLong();
            long persons = scanner.nextLong();
            System.out.print("Case #" + i + ": ");
            System.out.println(compute(stalls, persons).toString());

        }


    }

    private static lrClass compute(long stalls, long persons) {
        if (stalls == persons) return new lrClass(0, 0);


        lrClass lrClass = new lrClass(0, stalls - 1);
        PriorityQueue<lrClass> que = new PriorityQueue<>((int) stalls, lrClass);
        que.add(lrClass);


        for (int i = 1; i <= persons; i++) {
            lrClass q = que.poll();
            long entry = (q.second + q.first + 1) / 2L;

            if (i == persons) {
                return new lrClass(entry - q.first, q.second - entry);
            }
            lrClass l = new lrClass(q.first, entry - 1);
            lrClass r = new lrClass(entry + 1, q.second);

            que.add(l);
            que.add(r);


        }


        return null;
    }

    static class lrClass implements Comparator<lrClass> {
        long first;
        long second;

        lrClass(long first, long second) {
            this.first = Math.min(first, second);
            this.second = Math.max(first, second);
        }

        long diff() {
            return (second - first);
        }

        @Override
        public String toString() {
            return Math.max(first, second) + " " + Math.min(first, second);
        }

        @Override
        public int compare(lrClass o1, lrClass o2) {

            if (o1.diff() == o2.diff()) {

                return -1;

            }

            return (int) (o2.diff() - o1.diff());
        }
    }

}
