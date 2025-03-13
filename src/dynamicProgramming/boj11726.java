package dynamicProgramming;

import java.util.Scanner;

public class boj11726 {
    static int N;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] myMap;
    static int totalCount;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        myMap = new int[2][N];
        int[][] dp = new int[2][N];
        visited = new boolean[2][N];

        int tempCount = 0;
        int cases = 0;

        for (int y=0; y<2; y++) {
            for (int x=0; x<N; x++) {
                if (!visited[y][x]) DFS(y,x, tempCount);
            }
        }

//        if (totalCount == N) {
//            cases += 1;
//            tempCount = 0;
//            totalCount = 0;
//        }

    }
    private static boolean isSafe(int y, int x) {
        return 0 < y && y < N && 0 < x && x < N && myMap[y][x] != 1;
    }

    public static void DFS(int y, int x, int tempCount) {
        if (tempCount == 2) {
            totalCount += 1;
            return;
        }

        for (int dir=0; dir<4; dir++) {
            int newY = y + dy[dir];
            int newX = x + dx[dir];
            if (isSafe(newY,newX)) {
                myMap[newY][newX] = 1;
                visited[newY][newX] = true;
                tempCount += 1;
                //dp[newY][newX] = 1;
                DFS(newY,newX,tempCount);
            }
        }
    }
}
