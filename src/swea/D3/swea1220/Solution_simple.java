package swea.D3.swea1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_simple {

    static int N;
    static int[][] myMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int TC = 1; TC <= 10; TC++) {
            N = Integer.parseInt(br.readLine());
            myMap = new int[N][N];

            // 자성체 입력 받기
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    myMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int deadlock = 0;

            // 열 기준으로 탐색 자석은 위아래로 움직임
            for (int x = 0; x < N; x++) {
                boolean metN = false;  // N극 자석(1)을 만났는지 체크

                for (int y = 0; y < N; y++) {
                    if (myMap[y][x] == 1) {
                        metN = true;
                    } else if (myMap[y][x] == 2) {
                        if (metN) {
                            deadlock++;
                            metN = false;  // 교착 후 상태 초기화
                        }
                    }
                }
            }

            System.out.println("#" + TC + " " + deadlock);
        }
    }
}
