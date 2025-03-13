package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj14501gptver {
    static int[] period;
    static int[] prices;
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        period = new int[N];
        prices = new int[N];

        for (int i = 0; i < N; i++) {
            int T = sc.nextInt();
            int P = sc.nextInt();
            period[i] = T;
            prices[i] = P;
        }
        sc.close();

        int totalMaxPay = 0;

        for (int i = 0; i < N; i++) {
            totalMaxPay = Math.max(totalMaxPay, maxPay(i, 0));
        }
        System.out.println(totalMaxPay);
    }

    private static int maxPay(int i, int paySum) {
        if (i >= N) {
            return paySum;
        }

        int todayPay = prices[i];
        int todayPeriod = period[i];

        int nextDay = i + todayPeriod;

        int includePay = 0;
        if (nextDay <= N) {
            includePay = maxPay(nextDay, paySum + todayPay);
        }

        int excludePay = maxPay(i + 1, paySum);

        return Math.max(includePay, excludePay);
    }
}

