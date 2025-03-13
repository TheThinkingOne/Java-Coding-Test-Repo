package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11726_googleVer {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        dp[0] = dp[1] = 1;
        System.out.println(Tiling(N));
    }
    private static int Tiling(int n) {
        if(dp[n] == 0) {
            dp[n] = (Tiling(n-1) + Tiling(n-2)) % 10007;
        }
        return dp[n];
    }
}
