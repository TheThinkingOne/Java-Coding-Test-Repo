package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj13164_gpt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 그룹 수

        int[] heights = new int[N]; // 학생들의 키 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // String[] s = br.readLine().split(" "); 이거도 되는구나

        // 학생 키를 오름차순으로 정렬
        Arrays.sort(heights);

        // 인접한 학생들 간의 차이를 계산
        int[] diffs = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = heights[i + 1] - heights[i];
        }

        // 차이를 내림차순으로 정렬 (가장 큰 K-1개의 차이를 제거해야 하므로)
        System.out.println(Arrays.toString(diffs));

        Arrays.sort(diffs);

        System.out.println(Arrays.toString(diffs));

        // 가장 큰 K-1개의 차이를 제거한 나머지 차이의 합 계산
        // K개의 그룹을 만들려면 K−1개의 분리 지점이 필요
        int totalCost = 0;
        for (int i = 0; i < N - K; i++) {
            totalCost += diffs[i];
        }


        System.out.println(totalCost);
    }
}
