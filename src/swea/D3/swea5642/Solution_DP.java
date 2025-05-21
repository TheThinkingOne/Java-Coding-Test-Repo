package swea.D3.swea5642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_DP { // 1차원 dp 배열 이용해서 풀린 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());  // 테스트 케이스 수

        for (int t = 1; t <= TC; t++) {
            int N = Integer.parseInt(br.readLine());  // 수열 길이
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                // 1 3 -8 18 -8
            }

            // DP 배열 생성 및 초기화
            int[] dp = new int[N];
            dp[0] = arr[0];
            int max = dp[0];

            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
                // Math.max(3, 0+1) = 3
                // Math.max(-8,
                max = Math.max(max, dp[i]);
            }

            System.out.println("#" + t + " " + max);
        }
    }
}
