package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1932_dp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N]; // 다이나믹 프로그래밍을 위한 배열

        // 삼각형 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 설정
        dp[0][0] = triangle[0][0];

        // 다이나믹 프로그래밍으로 최대 합 구하기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j]; // 왼쪽 끝 경로
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]; // 오른쪽 끝 경로
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j]; // 중간 경로
                }
            }
        }

        // 최대값 찾기
        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, dp[N - 1][i]);
        }

        System.out.println(maxSum);
    }
}
