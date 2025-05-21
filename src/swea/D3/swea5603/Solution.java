package swea.D3.swea5603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(br.readLine());
                // 2 10 7 1
            }

            int arrSum = 0;
            for (int j = 0; j < N; j++) {
                arrSum += arr[j];
            }

            int avg = arrSum / N;
            int result = 0;
            for (int j : arr) {
                if (j < avg) result += avg - j;
            }

            System.out.println("#" + i + " " + result);

        }

    }
}
