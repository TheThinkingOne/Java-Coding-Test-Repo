package greedy;

import java.util.Scanner;

public class boj2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        int temp = 0;

        /*int share3 = N / 3;
        int share5 = N / 5;

        int rest3 = N % 3; // 3으로 나눈 나머지
        int rest5 = N % 5; // 5로 나눈 나머지

        *//*if (share5 == 0) { // 5로 나눴는데 안 나눠 떨어지면
            result += share5;
        }*/



        result += N / 5;
        if (N % 5 != 0) {
            N = N % 5;
        }
        result += N / 3;
        if (N % 3 != 0) {
            result = -1;
        }

        System.out.println(result);

    }
}
