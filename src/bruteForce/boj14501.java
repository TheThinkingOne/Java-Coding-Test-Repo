package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj14501 {
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

        for (int i=0; i<N; i++) {
            int result = maxPay(i,0);
            if (result > totalMaxPay) {
                totalMaxPay = result;
            }
        }
        System.out.println(totalMaxPay);
    }

    private static int maxPay(int i, int paySum) {
        //int today = i+1;
        int todayPay = prices[i]; // 오늘 잡힌 상담 하면 벌 수 있는 돈
        int todayPeriod = period[i]; // 오늘 상담 시작하면 걸리는 일수
        i += todayPeriod; // good
        if (i <= N-1) {
            if ((i==N-1) && (todayPeriod == 1)) { //마지막 날이 됬는데 그 날에 받는 상담의 진행기간이 1이 아닌경우 처리
                paySum += todayPay;
                return paySum;
            } else {
                paySum += todayPay;
                maxPay(i,paySum);
            }
        } else if (i > N-1) {
            return paySum;
        }
        return paySum;
    }
}
