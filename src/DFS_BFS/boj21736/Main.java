package DFS_BFS.boj21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static String[][] myMap;
    static int N, M;
    static boolean[][] vistied;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        vistied = new boolean[N][M];

        myMap = new String[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                myMap[i][j] = String.valueOf(line.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (myMap[i][j].equals("I")) {
                    DFS(i,j);
                    break; // 문제에서 "I"는 하나라고 가정하고, 처음 찾은 후 종료
                }
            }
        }

        // 아무도 만나지 못했을 경우
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }


    }

    public static boolean isSafe(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M && !vistied[y][x] && !myMap[y][x].equals("X");
    } // !visited[y][x] 조건 추가함

    public static void DFS(int y, int x) {
        vistied[y][x] = true;
        if (myMap[y][x].equals("P")) {
            count += 1;
        }
        for (int dir = 0; dir < 4; dir++) {
            int newY = y + dy[dir];
            int newX = x + dx[dir];

            if (isSafe(newY, newX)) {
                DFS(newY, newX);
            }
        }
    }

}
