package swea.swea12741;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // 첫 전구의 시작
            int B = Integer.parseInt(st.nextToken()); // 첫 전구의 끝
            int C = Integer.parseInt(st.nextToken()); // 두번째 시작
            int D = Integer.parseInt(st.nextToken()); // 두번째 끝

            int result = 0;

            if (C >= B || D <= A) result = 0;
            else {
                int start = Math.max(A, C);
                int end = Math.min(B, D);
                result = end - start;
            }


            System.out.println("#" + i + " " + result);

        }

        br.close();

    }
}
