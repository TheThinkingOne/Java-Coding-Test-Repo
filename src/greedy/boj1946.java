package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            int N = Integer.parseInt(br.readLine());
            int [][] score = new int[N][2];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken()); // 서류성적
                score[j][1] = Integer.parseInt(st.nextToken()); // 면접성적
            }

            System.out.println(Arrays.deepToString(score));

            Arrays.sort(score, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0]; // 종료시간 같으면 시작시간 비교
                    }

                    return o1[1] - o2[1];
                }
            });

            System.out.println(Arrays.deepToString(score));
            // 이 회사는

        }
    }
}
