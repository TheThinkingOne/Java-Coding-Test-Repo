package DFS_BFS.boj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int y;
        int x;
        int count;

        public Point(int y, int x, int count) {
            this.y = y;
            this.x = x;
            this.count = count;
        }
    }

    static int N;
    static int M;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N = 4
        M = Integer.parseInt(st.nextToken()); // M = 6
        visited = new boolean[N][M];

        int[][] myMap = new int[N][M];
        int[] dy = {-1,1,0,0};
        int[] dx = {0,0,-1,1};


        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                myMap[i][j] = line.charAt(j) -'0';
            }
        }



        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0,0,1));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int cy = current.y;
            int cx = current.x;

            if (cy == N-1 & cx == M-1) {
                System.out.println(current.count);
                return;
            }

            for (int dir=0; dir<4; dir++) {
                int newY = cy + dy[dir];
                int newX = cx + dx[dir];

                int newCount = current.count + 1;
                if (isSafe(newY,newX)) {
                    if (myMap[newY][newX] == 1 & !visited[newY][newX]) {
                        visited[newY][newX] = true;
                        queue.add(new Point(newY,newX,newCount));
                    }
                }

            }
        }
        System.out.println("인간은 노력하는 한 방황하는 법입니다.");

    }

    public static boolean isSafe(int y, int x) {
        return y >= 0 & y<N & x >= 0 & x < M;
    }


}
