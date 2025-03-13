package Implementation.boj14502;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class gptVer {
    static int N, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] MyMap;
    static ArrayList<Point> wall;
    static Point[] selected;
    static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MyMap = new int[N][M];
        wall = new ArrayList<>();

        //벽 놓을 후보 지역 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                MyMap[i][j] = Integer.parseInt(st.nextToken());
                if (MyMap[i][j] == 0) {
                    wall.add(new Point(i, j));
                }
            }
        }

        selected = new Point[3];
        Combination(0, 0);
        System.out.println(maxSafeArea);
    }

    //벽이 없는 지점 3개 찾아서 순열로 넣기
    private static void Combination(int count, int start) {
        if (count == 3) {
            // Simulation after placing walls
            Virus();
            return;
        }

        for (int i = start; i < wall.size(); i++) {
            selected[count] = wall.get(i);
            Combination(count + 1, i + 1);
        }
    }

    private static void Virus() {
        // 원래 맵 변경 막기 위해 myMapCopy 새로 선언
        int[][] myMapCopy = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(MyMap[i], 0, myMapCopy[i], 0, M);
        }

        //선택된 위치에 벽 놓기
        for (int i = 0; i < 3; i++) {
            Point makeWall = selected[i];
            myMapCopy[makeWall.x][makeWall.y] = 1; // Place a wall
        }

        //바이러스 확산 DFS시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (myMapCopy[i][j] == 2) {
                    DFS(i, j, myMapCopy);
                }
            }
        }

        //안전영역 구하기
        int safeArea = countSafeArea(myMapCopy);
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }

    private static void DFS(int startY, int startX, int[][] copyMap) {
        for (int dir = 0; dir < 4; dir++) {
            int ny = startY + dy[dir];
            int nx = startX + dx[dir];

            if (ny >= 0 && ny < N && nx >= 0 && nx < M && copyMap[ny][nx] == 0) {
                copyMap[ny][nx] = 2; // Spread virus
                DFS(ny, nx, copyMap);
            }
        }
    }

    private static int countSafeArea(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}

