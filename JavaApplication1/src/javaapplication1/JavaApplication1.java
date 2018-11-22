/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @author widyramadhani SOAL nomor 2 BUKALAPAK TEST CASE
 */
public class JavaApplication1 {

    public static List<String> listString = new ArrayList();

    public static void main(String[] args) {
        JavaApplication1 soalBukalapak = new JavaApplication1();
//        soalKedua.bukaLapakSoalKedua(2,3);
//        soalBukalapak.bukaLapakSoalKetiga(10, 10);
//        Integer i = Integer.bitCount(100) + Integer.highestOneBit(100) - 1;
//        System.out.println("Round Played = " + i);
//        int[] a = {93,95};
//        System.out.println(soalBukalapak.testCaseCodility(a));
        BigDecimal debet = BigDecimal.valueOf(Double.parseDouble("15"));
        BigDecimal kredit = BigDecimal.valueOf(Double.parseDouble("10"));
        if (debet.compareTo(kredit) > 0) {
            System.out.println("MASUKK");
        }

        String kode = "01.015.01";
        String muncul = kode.substring(0,2);
        System.out.println("MASUKK " + muncul);

    }

    private int testCaseCodility(int[] A) {
        Arrays.sort(A);

        if (A.length == 1) {
            if (A[0] < 0 || A[0] != 1) {
                return 1;

            } else {
                return (A[0] + 1);

            }
        } else if (A[0] < 0 || (A[0] < 1 && A[1] != 1)) {
//            System.out.println("1");
            return 1;
        } else {
            int firstTemp = 0;
            int tempMin = 1000000;
            int testValue = 1;
//            boolean status = IntStream.of(A).anyMatch(x -> x == testValue);
            for (int i = 0; i < A.length; i++) {
                if (i == 0) {
                    if (A[i] != A[i + 1] && A[i] + 1 != A[i + 1]) {
                        tempMin = A[i] + 1;
                    }
                } else if (i == A.length - 1) {
                    if (tempMin == 1000000) {
                        tempMin = (A[i] + 1);
                    }
                } else {
                    if (A[i] != A[i + 1] && A[i] + 1 != A[i + 1]) {
                        firstTemp = A[i] + 1;
                        if (firstTemp < tempMin) {
                            tempMin = firstTemp;
                        }
                    }
                }
            }
//            System.out.println(tempMin);
            return tempMin;
        }
    }

    private void bukaLapakSoalKetiga(int N, int K) {
        boolean status = true;
        int round = 0;
        int odd;
        String message = "";
        System.out.println("at the beginning: 1");
        while (status == true) {
            if (N > 1) {
                round++;
                if (K == 0) {
                    N = N - 1;
                    message = "(he bet 1)";
//                    System.out.println("Round = " + round + " ,nilai N = " + N);
                } else {
                    odd = N / 2;
                    N = N - odd;
                    K = K - 1;
                    message = "(all-in)";
//                    System.out.println("Round = " + round + " , nilai N = " + N + " , ALL-in yang bisa dilakukan = " + K);
                }
                System.out.println("after the " + round + " round: " + N + " " + message);
            } else {
                System.out.println("Round Played = " + round);
                status = false;
            }
        }
    }

    private void bukaLapakSoalKetigaB(int N, int K) {
        if (N <= 0) {
            System.out.println("Round Played = <" + 0);

        }
        if (N == 1) {
            System.out.println("Round Played = " + 1);
        }
        for (int i = 1;; i++) {
            if (N == 1) {
                System.out.println("Round Played = " + i);
            }
            if ((N % 2) == 0) {
                N /= 2;
            } else {
                N -= 1;
            }
        }



    }

    private void bukaLapakSoalKedua(int A, int B) {
        String str = "";
        for (int i = 0; i < A; i++) {
            str += "a";
        }
        for (int i = 0; i < B; i++) {
            str += "b";
        }
        int n = str.length();
        try {
            JavaApplication1 permutation = new JavaApplication1();
            permutation.permute(str, 0, n - 1);
            System.out.println(listString.get(0));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    /**
     * permutation function
     *
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r) {

        if (l == r) {
            if (!str.contains("aaa") && !str.contains("bbb")) {
                // System.out.println(str);
                listString.add(str);
            }
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    /**
     * Swap Characters at position
     *
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
