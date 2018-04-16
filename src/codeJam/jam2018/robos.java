package codeJam.jam2018;

import java.util.*;

public class robos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int r = s.nextInt();
            int b = s.nextInt();
            int c = s.nextInt();
            Queue<cashier> arr = new PriorityQueue<>(c, Comparator.comparingInt(cashier::getSpeedNext));

            for (int j = 0; j < c; j++) {
                arr.add(new cashier(s.nextInt(), s.nextInt(), s.nextInt()));
            }

            //   arr.sort(Comparator.comparingInt(cashier::getSpeedNext));

            System.out.print("Case #" + (i + 1) + ": ");
            compute(arr, r, b);


        }
    }

    private static void compute(Queue<cashier> arr, int r, int b) {

        int time = 0;
        int robosUsed = 0;
        int j = 0;
        boolean elinated = true;
        for (int i = 0; i < b; i++) {
            cashier poll = arr.poll();
            if (poll.add()) {
                time = poll.getTimeTaken(time);
                if (elinated && poll.newRobo()) robosUsed++;
                arr.add(poll);
            } else {
                // arr.remove(arr.peek());
                i--;
                j++;
            }

            if (elinated && robosUsed == r) {
                elinated = false;
                for (int k = arr.size() - 1; k >= 0; k--)
                    if (arr.peek().contains == 0)
                        arr.remove(arr.peek());
            }

            //   arr.sort(Comparator.comparingInt(cashier::getSpeedNext));
        }
        System.out.println(time);

    }

    static class cashier {
        int contains = 0;
        int maxItem;
        int time;
        int feesTime;

        int speedNext;


        boolean add() {
            if (contains < maxItem) {
                contains++;
                setSpeedNext();

                return true;
            }
            return false;
        }

        private int getTimeTaken(int currentTime) {
            if (contains == 1) {
                return time + feesTime;
            }
            return currentTime + time;
        }

        public cashier(int maxItem, int time, int feesTime) {
            this.maxItem = maxItem;
            this.time = time;
            this.feesTime = feesTime;

            speedNext = time + feesTime;
        }


        private void setSpeedNext() {
            speedNext = (contains + 1) * time + feesTime;
        }

        int getSpeedNext() {
            return speedNext;
        }

        public boolean newRobo() {
            return contains == 1;
        }
    }
}

