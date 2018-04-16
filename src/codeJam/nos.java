package codeJam;

import java.util.*;

public class nos {
    static String[] nos = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

    static List<Character> data;
    static List<Integer> formData;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int i = 0; i < t; i++) {
            String next = s.next();
            data = new ArrayList<>();
            formData = new ArrayList<>();
            char[] chars = next.toCharArray();
            for (char aChar : chars) data.add(aChar);
            Collections.sort(data);

            System.out.print("Case #" + (i + 1) + ": ");
            findNos2();


           /* findNos();


            Collections.sort(formData);
            for (Integer formDatum : formData) {
                System.out.print(formDatum);
            }
            System.out.println();*/

        }


    }

    private static void findNos2() {
        List<Character> primary = Arrays.asList('Z', 'W', 'U', 'X', 'G');
        List<Character> secondary = Arrays.asList('O', 'T', 'F', 'S', 'N');

        getData(primary, 0);
        getData(secondary, 1);

        Collections.sort(formData);
        for (Integer formDatum : formData) {
            System.out.print(formDatum);
        }
        System.out.println();


    }

    private static void getData(List<Character> keySet, int status) {


        for (int i = 0; i < keySet.size(); ) {
            int x = Collections.binarySearch(data, keySet.get(i));
            if (x >= 0) {
                char[] no1 = nos[i * 2 + status].toCharArray();
                for (char c : no1) {
                    data.remove((Character) c);
                }
                formData.add(i * 2 + status);
            } else {
                i++;
            }
        }


    }

    private static void findNos() {

        while (!data.isEmpty()) {
            for (int i = 0; i < nos.length; i++) {
                char[] no = nos[i].toCharArray();
                List<Character> vanish = new ArrayList<>();
                for (char aNo : no) {
                    int x = Collections.binarySearch(data, aNo);
                    if (x >= 0) {
                        data.remove(x);
                        vanish.add(aNo);
                    } else {
                        data.addAll(vanish);
                        vanish.clear();

                        break;
                    }
                }
                if (!vanish.isEmpty()) {
                    formData.add(i);
                }
                Collections.sort(data);

            }

        }
    }


}
