package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1463 {
    static int count;

    //백준 1463 1로 만들기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        count = 0;

        if (N == 1) {
            System.out.println(0);
        } else {
            makeOne(N);
            System.out.println(count);
        }

    }
    public static void makeOne(int num) {
        while (num != 1) {
            if (num % 3 == 0 || num % 6 == 0) {
                num /= 3;
                if (num == 10) {
                    count += 4;
                    break;
                }
            } else if (num % 2 == 0) {
                num /= 2;
                if (num == 10) {
                    count += 4;
                    break;
                }
            } else {
                num -= 1;
            }
            count++;
        }
    }
}
//        if (N == 1) {
//            System.out.println(0);
//        } else if (N % 3 == 0) {
//            divBy3(N, count);
//        } else if (N % 10 == 0) {
//            divBy2(N, count);
//        } else if (N % 3 != 0 && N % 2 != 0) {
//            minus1(N, count);
//        }
//        System.out.println(count);
//    }
//
//    public static void divBy3(int num, int count) {
//        while (num != 1) {
//            num %= 3;
//            count += 1;
//        }
//        System.out.println(count);
//
//    }
//
//    public static void divBy2(int num, int count) {
//        num %= 2;
//        count += 1;
//        if (num == 10) {
//            count += 3;
//            System.out.println(count);
//        } else if (N % 5 == 0) {
//            minus1(num, count);
//        }
//    }
//
//    public static void minus1(int N, int count) {
//        N -= 1;
//        count += 1;
//        if (N % 3 == 0) {
//            divBy3(N, count);
//        } else {
//            while (N != 10) {
//                N %= 2;
//                count += 1;
//            }
//            count += 3;
//            System.out.println(count);
//        }
//    }
