package swea.swea10032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int result = 0;
            // N개의 과자를 K명의 사람들에게 분배
            // 과자를 가장 많이 받은 사람과 적게 받은 사람의 과자 수 차이를 최소화
            // bruteforce?

            if (N % K != 0) {
                for (int j=1; j<=N; j++) {
                    if (j*K > N) {
                        // int diff = j*K - N;
                        result = 1;
                        break;
                    }


                    /*int div = N%j;
                    int divMul = div * j;*/
                    /*if (div * K < N) {
                        continue;
                    }
                    else if (div * K >= N) {

                    }*/
                }
            }

            System.out.println("#" + i + " " + result);

        }

    }
}
