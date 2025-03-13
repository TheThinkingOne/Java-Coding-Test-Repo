package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2156 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // 세잔 연속은 못마심

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬해서 하는 것 안됨
        int[][] dp = new int[N][N];
        int count = 0;
        int result = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            int start = arr[i];
            int after = dp(start,i,count,result);
            if (after > max) max = after;
        }

        System.out.println(max);



    }

    private static int dp(int start, int i, int count, int result) {
        count++;
        result += start;

        if (i == N - 1) return result;

        if (count == 2) {
            count = 0;
            for (int j = i+1; j < N; j++) {
                int current = arr[j];
                dp(current, j, count, result);
            }
        }

        for (int j=i; j<N; j++) {
            int current = arr[j];
            dp(current, j, count, result);
        }

        return 0;
    }
}
