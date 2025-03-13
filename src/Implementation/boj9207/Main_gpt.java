package Implementation.boj9207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_gpt {

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] list;
    static int minPins, minMoves;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            list = new char[5][9];
            for (int j = 0; j < 5; j++) {
                String line = br.readLine();
                for (int k = 0; k < 9; k++) {
                    list[j][k] = line.charAt(k);
                }
            }
            // 빈 줄 처리
            br.readLine();

            System.out.println(Arrays.deepToString(list));

            // 초기화
            minPins = Integer.MAX_VALUE;
            minMoves = Integer.MAX_VALUE;

            int initialPins = 0;
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 9; y++) {
                    if (list[x][y] == 'o') initialPins++;
                }
            } // DFS 탐색 하기 전에 핀이 몇개 있는지 체크

            // DFS 탐색
            dfs(initialPins, 0);

            // 결과 출력
            System.out.println(minPins + " " + minMoves);
        }

        br.close();
    }

    private static boolean isSafe(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 9 && list[x][y] != '#';
        // 갈 수 있는지 체크하는 메소드
    }

    private static void dfs(int pins, int moves) {
        boolean canMove = false;

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 9; y++) {
                if (list[x][y] == 'o') { // 핀이면
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        int nnx = x + 2 * dx[dir]; // 상하두칸 와 이걸 생각못했노
                        int nny = y + 2 * dy[dir]; // 좌우두칸 와 이걸 생각못했노

                        if (isSafe(nx, ny) && isSafe(nnx, nny) && list[nx][ny] == 'o' && list[nnx][nny] == '.') {
                            // 이동
                            list[x][y] = '.'; // 원래있던곳 빈칸으로 갱신
                            list[nx][ny] = '.'; // 인접한 핀도 빈칸으로 갱신
                            list[nnx][nny] = 'o'; // 이동한 곳 핀으로 갱신

                            dfs(pins - 1, moves + 1);

                            // 원복 (백트래킹)
                            list[x][y] = 'o'; // 원래 위치 핀 복원
                            list[nx][ny] = 'o'; // 뛰어넘은 곳도 핀 다시 복원
                            list[nnx][nny] = '.'; // 이동 후 위치 빈 칸으로

                            canMove = true;
                        }
                    }
                }
            }
        }

        // 이동이 불가능한 경우 결과 업데이트
        if (!canMove) {
            if (pins < minPins || (pins == minPins && moves < minMoves)) {
                minPins = pins;
                minMoves = moves;
            }
        }

    }
}

