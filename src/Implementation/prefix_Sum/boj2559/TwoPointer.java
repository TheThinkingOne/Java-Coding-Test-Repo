package Implementation.prefix_Sum.boj2559;

//package Implementation.prefix_Sum.boj2559;

import java.util.*;
import java.io.*;

public class TwoPointer {
    // 투 포인터로 구한 버전
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] myMap = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            myMap[i] = Integer.parseInt(st.nextToken());
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        // 초기 윈도우 설정
        for (int i = 0; i < K; i++) {
            currentSum += myMap[i];
        }
        maxSum = currentSum;

        // 윈도우를 오른쪽으로 한 칸씩 이동
        for (int i = K; i < N; i++) {
            currentSum += myMap[i] - myMap[i - K];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        System.out.println(maxSum);
    }
}

