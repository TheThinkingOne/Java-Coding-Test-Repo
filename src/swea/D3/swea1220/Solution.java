package swea.D3.swea1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static boolean[][] visited;
    static int[][] myMap;
    static int deadlock;
    static int[] dy = {0,0,-1,1};
    static int[] dx = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int TC=1; TC<=10; TC++) {

            N = Integer.parseInt(br.readLine());
            myMap = new int[N][N];
            visited = new boolean[N][N];
            deadlock = 0;

            // 1은 N극, 2는 S극
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    myMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 1은 N자석, 2는 S자석
            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++) {
                    if (myMap[x][y] == 1) {
                        visited[x][y] = true;
                        isN(x,y);
                    }
                    else if (myMap[x][y] == 2) {
                        visited[x][y] = true;
                        isS(x,y);
                    }
                }
            }


        }
    }

    private static boolean isSafe(int x, int y) {
        return 0<y && y<N && 0<x && x<N;
    }

    // 위가 N극 판, 아래가 S극 판
    // 1은 N자석, 2는 S자석
    // S자석 들어옴
    private static void isS(int x, int y) {
        // 맨 위 N극판 까지 합해서 그대로면 없애기
        boolean flag = false;
        for (int newY=y; y>=0; y--) { // 자기 바로 위 부터 맨 위까지 비교
            if (myMap[x][newY] == 1) { // S 자석 만나면 stop
                //deadlock++;
                flag = true;
                break;
            }
        }
        if (!flag) {
            myMap[x][y] = 0;
        }


    }

    // 위가 N극 판, 아래가 S극 판
    // 1은 N자석, 2는 S자석
    // N 자석 들어옴
    private static void isN(int x, int y) {
        // 자기 바로 아래칸부터 아래 S극판 까지 조사
        boolean flag = false;
        for (int newY=y; newY<N; newY++) {
            if (myMap[x][newY] == 2) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            myMap[x][y] = 0;
        }
    }
}
