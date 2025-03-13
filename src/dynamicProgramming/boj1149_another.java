package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1149번 RGB 거리
public class boj1149_another {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 26,49,13
            int g = Integer.parseInt(st.nextToken()); // 40,60,57h
            int b = Integer.parseInt(st.nextToken()); // 83,57,99

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
            // dp[1][0] = min(dp[0][1], dp[0][2]) + 26 = 26
            // dp[2][0] = min(dp[1][1], dp[1][2]) + 49 = min(40,83) + 49 = 89
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
            // dp[1][1] = min(dp[0][0], dp[0][2]) + 40 = 40
            // dp[2][1] = min(dp[1][0], dp[1][2]) + 60 = min(26,83) + 60 = 86
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
            // dp[1][2] = min(dp[0][0], dp[0][1]) + 83 = 83
            // dp[2][2] = min(dp[1][0], dp[1][1]) + 57 = min(26,40) + 57 = 83

            // ......
            // 최솟값 : 26 + 57 + 13 = 103
        }
        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));

    }
}
