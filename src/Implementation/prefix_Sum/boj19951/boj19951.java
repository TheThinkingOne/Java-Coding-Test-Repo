package Implementation.prefix_Sum.boj19951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj19951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 연병장 크기
        int M = Integer.parseInt(st.nextToken()); // 조교 수

        int[] myMap = new int[N + 1];
        int[] diff = new int[N + 2];

        // 초기 높이 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            myMap[i] = Integer.parseInt(st.nextToken());
        }

        // 명령 처리
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            // 시작지점이랑 끝부분+1 지점에 각각 높이를 더하고 뺌
            diff[start] += height;
            diff[end + 1] -= height; // 여길 왜 하는거지
        }

        // 차이 배열을 누적합으로 변환
        int[] result = new int[N + 1];
        result[1] = myMap[1] + diff[1];

        for (int i = 2; i <= N; i++) {
            diff[i] += diff[i - 1];
            result[i] = myMap[i] + diff[i];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}

