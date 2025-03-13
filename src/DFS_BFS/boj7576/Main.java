package DFS_BFS.boj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 백준 7576 토마토
    static int N;
    static int M;
    static int[][] MyMap;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                MyMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = BFS();
        if (result == -1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    public static boolean isSafe(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    public static int BFS() {
        int days = -1;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MyMap[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] candidates = queue.poll();
                int cy = candidates[0];
                int cx = candidates[1];

                for (int dir = 0; dir < 4; dir++) {
                    int newY = cy + dy[dir];
                    int newX = cx + dx[dir];

                    if (isSafe(newY, newX) && MyMap[newY][newX] == 0) {
                        MyMap[newY][newX] = 1;
                        queue.add(new int[]{newY, newX});
                    }
                }
            }
            days += 1;
        }

        // Check for unripe tomatoes
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (MyMap[i][j] == 0) {
                    return -1;
                }
            }
        }

        return days;
    }
}




