package Implementation.boj14502;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] MyMap;
    static ArrayList<Point> wall;
    static Point[] selected;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MyMap = new int[M][N];
        wall = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                MyMap[i][j] = Integer.parseInt(st.nextToken());
                if (MyMap[i][j] == 0) {
                    wall.add(new Point(i,j));
                }
            }
        }

        selected = new Point[M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (MyMap[i][j] == 2) {
                    int startY = i;
                    int startX = j;
                    DFS(startY, startX);
                }
            }
        }


    }

    private static void Combination(int count) {

    }

    private static void DFS(int startY, int startX) {

    }
}
