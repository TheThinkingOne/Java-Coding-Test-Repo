package Implementation.shortestdistance.boj1389;

import java.io.*;
import java.util.StringTokenizer;

public class GoogleVer {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] friends = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                friends[i][j] = INF;
                if (i == j) {
                    friends[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            friends[num1][num2] = 1;
            friends[num2][num1] = 1;
        }

        // K: 거쳐가는 노드, i: 출발 노드, j: 도착 노드
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    // 어차피 문제 특성상 직접 연결된게 아니면 다 INF 처리 되어있음
                    if (friends[i][j] > friends[i][k] + friends[k][j]) { // 한단계 거치는것이 1선 보다 값이 작다면
                        friends[i][j] = friends[i][k] + friends[k][j]; // 갱신
                    }
                }
            }
        }

        int result = INF;
        int index = -1;

        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += friends[i][j]; // 각 사람별로 케빈베이컨 총합 구하기
            }

            if (total < result) {
                result = total;
                index = i; // 가장 케빈 베이컨이 작은사람(index) 추출
            }
        }

        System.out.println(index);
    }
}

