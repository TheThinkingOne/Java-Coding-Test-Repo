package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2156_gpt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //시@팔 존나어렵네
        // DP는 과거의 값을 토대로 구하는게 핵심이다
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }

        int[] dp = new int[N];

        // 초기값 설정
        dp[0] = arr[0]; // 6
        dp[1] = arr[0] + arr[1]; // 16
        if (N > 2) {
            dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));
            //                16                  6 + 13  ,   10 + 13
        }

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], // i번째 잔 마시지 않는경우
                    Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
            // dp[i-2] + arr[i]: i번째 잔을 마시고, i-1번째 잔을 마시지 않는 경우.
            // dp[i - 3] + arr[i - 1] + arr[i] : i번째 잔과 i-1번째 잔을 모두 마시고,
            // i-2번째 잔은 마시지 않는 경우.
        }

        System.out.println(dp[N - 1]);
        /*System.out.println(dp[2]);
        System.out.println(dp[3]);
        System.out.println(dp[4]);
        System.out.println(dp[5]);*/
    }
}

