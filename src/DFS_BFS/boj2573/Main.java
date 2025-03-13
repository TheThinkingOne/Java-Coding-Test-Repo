package DFS_BFS.boj2573;

import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] MyMap;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        MyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                MyMap[i][j] = scanner.nextInt();
            }
        }

        int yearCount = 0;
        while (true) {
            int icebergCount = countIcebergs();

            if (icebergCount == 0) { // 빙산영역이 한번에 다 녹아서 분리된 빙하가 없으면 0 출력
                System.out.println(0);
                break;
            }

            if (icebergCount >= 2) { // 나눠진 빙산영역이 2개 이상이면 지나간 해의 수 출력
                System.out.println(yearCount);
                break;
            }

            MyMap = meltIce();
            yearCount++;
        }
    }

    static boolean isSafe(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    static int[][] meltIce() {
        int[][] newMap = new int[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (MyMap[y][x] > 0) {
                    int seaCount = 0;
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if (isSafe(ny, nx) && MyMap[ny][nx] == 0) {
                            seaCount++; // 주변 상하좌우의 바닷물 만큼 현재 위치에서 빼주는 역할
                        }
                    }
                    newMap[y][x] = Math.max(0, MyMap[y][x] - seaCount);
                }
            }
        }
        return newMap;
    }

    static int countIcebergs() { // 붙어있는 빙산 땅덩어리 계산하는 메서드
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (MyMap[y][x] > 0 && !visited[y][x]) {
                    count++;
                    dfs(y, x, visited);
                }
            }
        }
        return count;
    }

    static void dfs(int y, int x, boolean[][] visited) { // 붙어있는 빙산 탐색하는 DFS 메서드
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (isSafe(ny, nx) && MyMap[ny][nx] > 0 && !visited[ny][nx]) {
                dfs(ny, nx, visited);
            }
        }
    }
}

