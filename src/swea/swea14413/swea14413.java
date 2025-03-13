package swea.swea14413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea14413 {

    static int N;
    static int M;
    static int count;
    static String result;
    static boolean[][] visited;
    static char[][] myMap;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            myMap = new char[N][M];
            visited = new boolean[N][M];

            result = "";

            for (int j = 0; j < N; j++) {
                String line = br.readLine();
                char[] chars = line.toCharArray();
                for (int k = 0; k < M; k++) {
                    myMap[j][k] = chars[k];
                }
            }

            //System.out.println(Arrays.deepToString(myMap));
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (myMap[x][y] == '#' || myMap[x][y] == '.') {
                        String isPossible = DFS(x, y);
                        if (isPossible.equals("possible")) {
                            result = "possible";
                            break;
                        } else if (isPossible.equals("impossible")) {
                            result = "impossible";
                            break;
                        }
                    }
                }
            }

            System.out.println("#" + (i+1) + " " + result);

        }
    }

    private static String DFS(int x, int y) {
        visited[x][y] = true;
        count++;
        if (count == N*M) return "possible";

        char currentColor = myMap[x][y]; // # 또는 .
        for (int dir=0; dir<4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (isSafe(newX, newY)) {
                char nextColor = myMap[newX][newY];
                if (nextColor == currentColor) {
                    return "impossible";
                }
                if (myMap[newX][newY] == '?') {
                    if (currentColor == '#') {
                        myMap[newX][newY] = '.';
                        DFS(newX, newY);
                    } else {
                        myMap[newX][newY] = '#';
                        DFS(newX, newY);
                    }
                } else {
                    DFS(newX, newY);
                }
            }
        }

        return "possible";
    }

    private static boolean isSafe(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
