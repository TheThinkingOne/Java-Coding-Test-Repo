package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1946_gpt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < TC; i++) {
            int N = Integer.parseInt(br.readLine()); // 지원자 수
            int[][] score = new int[N][2]; // [서류 성적, 면접 성적]

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken()); // 서류 성적
                score[j][1] = Integer.parseInt(st.nextToken()); // 면접 성적
            }

            // 서류 성적 기준으로 오름차순 정렬
            Arrays.sort(score, (o1, o2) -> Integer.compare(o1[0], o2[0]));

            System.out.println(Arrays.deepToString(score));

            // 최소 면접 등수를 추적하며 선발 가능한 지원자 수 계산
            int selectedCount = 1; // 첫 번째 지원자는 항상 선발 가능
            int minInterviewRank = score[0][1]; // 첫 번째 지원자의 면접 성적 // 4

            for (int j = 1; j < N; j++) {
                // 현재 지원자의 면접 성적이 최소 면접 성적보다 낮으면 선발 가능
                if (score[j][1] < minInterviewRank) { // 3 < 4 => true
                    selectedCount++;
                    minInterviewRank = score[j][1]; // 최소 면접 성적 갱신
                }
            }

            System.out.println(selectedCount); // 1 + 3
        }
    }
}
