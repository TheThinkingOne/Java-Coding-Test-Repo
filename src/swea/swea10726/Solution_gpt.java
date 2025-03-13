package swea.swea10726;

// package swea.swea10726;
// gpt 선생님버전

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_gpt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // N개의 마지막 비트가 모두 1인지 확인
            int mask = (1 << N) - 1; // 2^N - 1
            String result = (M & mask) == mask ? "ON" : "OFF";

            System.out.println("#" + i + " " + result);
        }

        br.close();
    }
}

