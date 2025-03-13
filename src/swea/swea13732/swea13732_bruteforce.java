package swea.swea13732;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea13732_bruteforce {
    static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= TC; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][N];

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
            }

            boolean isValid = false; // 첫 번째 정사각형이 유효한지 여부
            boolean foundSquare = false; // 정사각형을 찾았는지 여부

            // 모든 좌표에 대해 탐색
            outerLoop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '#') {
                        if (foundSquare) { // 이미 정사각형을 찾았는데 또 다른 # 발견 시
                            isValid = false;
                            break outerLoop;
                        }
                        // 가능한 모든 크기의 정사각형을 검사
                        for (int size = 1; i + size <= N && j + size <= N; size++) {
                            if (isValidSquare(i, j, size)) {
                                isValid = true; // 유효한 정사각형 발견
                                foundSquare = true; // 첫 번째 정사각형 발견 표시
                                break; // 정사각형을 찾으면 종료
                            }
                        }
                    }
                }
            }

            // 결과 출력에서 isValid와 foundSquare 모두 확인
            System.out.println("#" + t + " " + (isValid && foundSquare ? "yes" : "no"));

        }
    }

    // 해당 좌표에서 주어진 크기의 정사각형이 유효한지 확인
    private static boolean isValidSquare(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != '#') {
                    return false;
                }
            }
        }
        return true;
    }
}
