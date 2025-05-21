package swea.D3.swea5607;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {

    static final int MAX = 1000000;
    static final int MOD = 1234567891;
    static long[] fact = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 1. factorial 미리 계산
        fact[0] = 1;
        for (int i = 1; i <= MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            long result = fact[n];
            result = (result * modInverse(fact[r], MOD)) % MOD;
            result = (result * modInverse(fact[n - r], MOD)) % MOD;

            System.out.println("#" + tc + " " + result);
        }
    }

    // 2. 페르마의 소정리를 이용한 모듈러 역원
    static long modInverse(long a, int mod) {
        return pow(a, mod - 2);
    }

    // 3. 빠른 거듭제곱 (재귀로 구현)
    static long pow(long base, int exp) {
        if (exp == 0) return 1;
        long half = pow(base, exp / 2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) result = (result * base) % MOD;
        return result;
    }
}
