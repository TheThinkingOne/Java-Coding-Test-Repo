package swea.swea14413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea14413_clear {

    static int N;
    static int M;
    static boolean[][] visited;
    static char[][] myMap;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            myMap = new char[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < N; j++) {
                String line = br.readLine();
                myMap[j] = line.toCharArray();
            }

            boolean possible = true;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (!visited[x][y] && myMap[x][y] != '?') {
                        if (DFS(x, y) == false) {
                            possible = false;
                            break;
                        }
                    }
                }
                if (!possible) break;
            }

            System.out.println("#" + (t + 1) + " " + (possible ? "possible" : "impossible"));
        }
    }

    private static boolean DFS(int x, int y) {
        visited[x][y] = true;
        char currentColor = myMap[x][y]; // # 또는 .

        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (isSafe(newX, newY) && !visited[newX][newY]) {
                if (myMap[newX][newY] == '?') {
                    // 현재 색에 반대되는 색을 넣고 DFS 재귀 호출
                    myMap[newX][newY] = (currentColor == '#') ? '.' : '#';
                    if (!DFS(newX, newY)) return false;
                } else if (myMap[newX][newY] == currentColor) {
                    // 같은 색을 만났을 때 불가능한 경우
                    return false;
                } else {
                    // 이미 다른 색이 잘 맞춰져 있는 경우
                    if (!DFS(newX, newY)) return false;
                }
            }
        }
        return true;
    }

    private static boolean isSafe(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}

