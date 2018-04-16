package codeinGame;

import java.sql.Time;
import java.util.Scanner;

public class TIME {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String L = in.nextLine();
        int N = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }

        timer time = new timer();
        for (int i = 0; i < N; i++) {
            String T = in.nextLine();
            timer tim = new timer(T);
            time.add(tim);
        }
        timer timer = new timer(L);

        System.out.println(time.equals(timer));

    }

    static class timer {
        int hr;
        int min;
        int sec;

        public timer() {
            this.hr = 0;
            this.min = 0;
            this.sec = 0;
        }

        public timer(String s) {
            String[] split = s.split(":");

            this.hr = Integer.parseInt(split[0]);
            this.min = Integer.parseInt(split[1]);
            this.sec = Integer.parseInt(split[2]);
        }


        public void add(timer time) {
            this.sec += time.sec;
            this.min += time.min;
            this.hr += time.hr;

            this.sec = this.sec % 60;
            int mint = this.sec / 60;
            this.min += mint;

            this.min = this.min % 60;
            int hr = this.min / 60;
            this.hr += hr;

        }

        public boolean equals(timer timer) {
            return this.hr <= timer.hr && this.min <= timer.min && this.sec <= timer.sec;
        }
    }
}
