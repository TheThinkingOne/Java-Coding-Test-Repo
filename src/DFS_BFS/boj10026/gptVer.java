package boj10026;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gptVer {

    static int N;
    static char[][] MyMap;
    static boolean[][] Visited;
    static int Area;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        MyMap = new char[N][N];
        Visited = new boolean[N][N];
        // 따로 true로 명시하지 않는 이상, Visited 배열의 모든 요소는 처음에 false 상태
        Area = 0;

        for (int i = 0; i < N; i++) {
            char[] area = br.readLine().toCharArray();
            MyMap[i] = area;
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!Visited[y][x]) {
                    normalDFS(y, x);
                    Area += 1;
                }
            }
        }

        System.out.print(Area + " ");

        Visited = new boolean[N][N];
        Area = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!Visited[y][x]) {
                    greenRedDFS(y, x);
                    Area += 1;
                }
            }
        }

        System.out.println(Area);

        br.close();
    }

    static boolean isSafe(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < N && !Visited[y][x];
    }

    static void normalDFS(int y, int x) {
        char currentColor = MyMap[y][x];
        Visited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int newY = y + dy[dir];
            int newX = x + dx[dir];

            if (isSafe(newY, newX) && MyMap[newY][newX] == currentColor) {
                normalDFS(newY, newX);
            }
        }
    }

    static void greenRedDFS(int y, int x) {
        char currentColor = MyMap[y][x];
        Visited[y][x] = true;

        for (int dir = 0; dir < 4; dir++) {
            int newY = y + dy[dir];
            int newX = x + dx[dir];

            if (currentColor == 'B') {
                if (isSafe(newY, newX) && MyMap[newY][newX] == currentColor) {
                    greenRedDFS(newY, newX);
                }
            } else {
                if (isSafe(newY, newX) && MyMap[newY][newX] != 'B') {
                    greenRedDFS(newY, newX);
                }
            }
        }
    }
}



