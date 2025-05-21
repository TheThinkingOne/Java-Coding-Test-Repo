package swea.D3.swea22574;

import java.io.IOException;
import java.util.Scanner;

public class Solution_correct {
    public static int dp(int N, int P) {
        // 1부터 N 까지 더하는데 문제 없으면 끝까지 더한거 리턴하고
        // 아니면 r-1 을 리턴? 근데 왜 r-1 을 리턴?
        // N(N+1)/2 가 1부터 N까지 더한 합과 같은 결과인가?
        int r = N * (N + 1) / 2;
        int f = 0;
        for (int i = 1; i <= N; i++) {
            f += i;
            if (f == P) {
                return r - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int P = sc.nextInt();
            int result = dp(N, P);
            System.out.println(result);
        }
    }
}