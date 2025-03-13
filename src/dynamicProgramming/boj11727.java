package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;
        //System.out.println(Tiling(N));
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
        }
        System.out.println(dp[N]);
    }

//    private static int Tiling(int N) {
//        if (dp[N] == 0) {
//            dp[N] = (dp[N-1] + 2*dp[N-2]) % 10007;
//        } else if (N==2) {
//            return 3;
//        } else if (N==1) {
//            return 1;
//        }
//        return dp[N];
//    }
}
