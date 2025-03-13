package DFS_BFS.boj2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] MyMap;
    static ArrayList<Integer> notColoredLand;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        MyMap = new int[N][M];
        visited = new boolean[N][M];
        notColoredLand = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
            }
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    MyMap[y][x] = 1;
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (MyMap[y][x] == 0 && !visited[y][x]) {
                    BFS(y, x);
                }
            }
        }

        Collections.sort(notColoredLand);
        System.out.println(notColoredLand.size());

        for (int land : notColoredLand) {
            System.out.print(land + " ");
        }
    }

    public static boolean isSafe(int y, int x) {
        return 0 <= x && x < M && 0 <= y && y < N && MyMap[y][x] == 0 && !visited[y][x];
    }

    public static void BFS(int startY, int startX) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            count++;

            for (int dir = 0; dir < 4; dir++) {
                int newY = cy + dy[dir];
                int newX = cx + dx[dir];

                if (isSafe(newY, newX)) {
                    queue.offer(new int[]{newY, newX});
                    visited[newY][newX] = true;
                }
            }
        }

        notColoredLand.add(count);
    }
}



