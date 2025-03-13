package DFS_BFS.boj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    // 백준 2206 벽 부수고 걸어가기
    static int N;
    static int M;
    static int[][] MyMap;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static boolean isSafe(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                MyMap[i][j] = row.charAt(j) - '0';
            }
        }

    }

    public static int BFS() {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();



        return -1;
    }
}

