package Implementation.boj9207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] list;
    static int moved;
    static int remainPin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // '.'는 빈 칸, 'o'는 핀이 꽂혀있는 칸, '#'는 구멍이 없는 칸
        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {

            list = new char[5][9];
            visited = new boolean[5][9];
            for (int j = 0; j < 5; j++) {
                String line = br.readLine();
                char[] chars = line.toCharArray();
                for (int k = 0; k < 9; k++) {
                    list[j][k] = chars[k];
                }
            }

            // 빈 줄 처리
            br.readLine();

            // System.out.println(Arrays.deepToString(list));


            // 핀은 수평, 수직 방향으로 인접한 핀을 뛰어넘어서 그 핀의 다음 칸으로 이동하는 것만 허용된다.
            // 인접한 핀의 다음 칸은 비어있어야 하고 그 인접한 핀은 제거된다.
            moved = 0;
            remainPin = 0;

            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 9; y++) {
                    if (list[x][y] == 'o' && !visited[x][y]) {
                        visited[x][y] = true;
                        DFS(x,y);
                    }
                }
            }

            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 9; y++) {
                    if (list[x][y] == 'o') remainPin++;
                }
            }

            System.out.print(remainPin + " ");
            System.out.println(moved);


            /*// 각 줄 출력
            for (char[] row : list) {
                System.out.println(new String(row));
            }
            System.out.println(); // 테스트 케이스 간 빈 줄 추가*/
        }

        br.close();
    }

    private static boolean isSafe(int y, int x) {
        return 0 <= y && y < 9 && 0 <= x && x < 5 && list[x][y] != '#';
    }


    private static void DFS(int x, int y) {
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dy[dir];
            int newY = y + dx[dir];
            // x,y 어디로 갔는지 비교해서 연산해야함
            if (isSafe(newY,newX) && list[newX][newY] == 'o') {
                // list[x][y] = '.';
                move(newX, newY, x, y);
            }
        }
    }

    private static void move(int newX, int newY, int x, int y) {
        if (newY > y) { // 오른쪽으로 이동하는 경우
            if (list[newX][newY+1] == '.' && isSafe(newY+1, newX)) { // 오른쪽이 빈칸이고 갈수있는구역이면
                list[newX][newY+1] = 'o';

                moved++; visited[newX][newY+1] = true;
                list[newX][newY] = '.'; // 인접했던 핀 제거
                list[x][y] = '.'; // 처음 위치의 핀이 옮겨졌음으로 맵에서 핀 제거
                DFS(newX, newY+1);
            }
        }
        else if (newY < y) { // 왼쪽이동경우
            if (list[newX][newY-1] == '.' && isSafe(newY-1, newX)) { // 왼쪽이 빈 칸이고 갈수있는구역이면
                list[newX][newY-1] = 'o';
                moved++; visited[newX][newY-1] = true;
                list[newX][newY] = '.';
                list[x][y] = '.'; // 처음 위치의 핀이 옮겨졌음으로 맵에서 핀 제거
                DFS(newX, newY-1);
            }
        }
        else if (newX > x) { // 위로 이동 경우
            if (list[newX-1][newY] == '.' && isSafe(newY, newX-1)) { // 위 빈칸, 갈수있으면
                list[newX-1][newY] = 'o';
                moved++; visited[newX-1][newY] = true;
                list[newX][newY] = '.';
                list[x][y] = '.'; // 처음 위치의 핀이 옮겨졌음으로 맵에서 핀 제거
                DFS(newX-1, newY);
            }
        }
        else if (newX < x) { // 아래로 이동 경우
            if (list[newX+1][newY] == '.' && isSafe(newY, newX+1)) { // 아래 빈칸, 갈 수 있으면
                list[newX+1][newY] = 'o';
                moved++; visited[newX+1][newY] = true;
                list[newX][newY] = '.';
                list[x][y] = '.'; // 처음 위치의 핀이 옮겨졌음으로 맵에서 핀 제거
                DFS(newX, newY+1);
            }
        }
    }

}
