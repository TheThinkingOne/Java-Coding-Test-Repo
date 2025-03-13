package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea13732_gpt { // 정사각형 판정 문제

    static int N;
    static int count;
    static int startX, startY, checkX, checkY;
    static char[][] myMap;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            myMap = new char[N][N];
            visited = new boolean[N][N];
            boolean isSingleSquare = false; // 정사각형이 하나만 있는지 체크

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                myMap[i] = line.toCharArray();
            }

            boolean isValid = true;

            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && myMap[x][y] == '#') {
                        if (isSingleSquare) { // 이미 정사각형이 하나 발견된 경우
                            isValid = false;
                            break;
                        }
                        startX = x;
                        startY = y;
                        checkX = x;
                        checkY = y;
                        count = 0;
                        if (!findSquare(x, y) || !isValidSquare()) {
                            isValid = false;
                            break;
                        }
                        isSingleSquare = true; // 첫 번째 정사각형 발견
                    }
                }
                if (!isValid) break;
            }

            System.out.println("#" + t + " " + (isValid ? "yes" : "no"));
        }
    }

    private static boolean isSafe(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N && myMap[x][y] == '#';
    }

    private static boolean findSquare(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int dir = 0; dir < 4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (isSafe(newX, newY) && !visited[newX][newY]) {
                if (newX > checkX) checkX = newX; // 좌표 갱신
                if (newY > checkY) checkY = newY; // 좌표 갱신

                if (!findSquare(newX, newY)) return false;
                // 더 이상 갈 수 없을 경우(전부 방문했거나 갈 수 있는 # 없거나 범위 벗어나면)
            }
        }
        return true;
    }

    private static boolean isValidSquare() {
        int width = checkX - startX + 1; // 배열인덱스는 0부터 시작하므로 + 1 해줘야함
        int height = checkY - startY + 1; // 마찬가지

        if (width != height || count != width * height) {
            // 가로세로 다르거나 넓이가 count 아니면 false (정사각형)
            return false;
        }

        // 해당 영역이 모두 '#'으로 채워져 있는지 확인
        for (int i = startX; i <= checkX; i++) {
            for (int j = startY; j <= checkY; j++) {
                if (myMap[i][j] != '#') return false;
            }
        }

        return true;
    }
}
