package swea.swea13732;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea13732 { // 정사각형 판정 문제

    static int N;
    static int count;
    static int startX; static int startY;
    static int checkX; static int checkY;
    static int totalSquareCount;
    static char[][] myMap;
    static boolean[][] visited;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            myMap = new char[N][N];
            visited = new boolean[N][N];
            boolean isSingleSquare = false;
            count = 0;
            totalSquareCount = 0;
            startX = 0; startY = 0; checkX = 0; checkY = 0;

            for (int j=0; j<N; j++) {
                String line = br.readLine();
                myMap[j] = line.toCharArray();
            }

            boolean isValid = true;

            for (int x=0; x<N; x++) {
                for (int y=0; y<N; y++) {
                    if (!visited[x][y] && myMap[x][y] == '#') {
                        startX = x; startY = y;
                        checkX = x; checkY = y;
                        isSquare(x,y);
                        // 총 정사각형의 갯수도 세어줘야함
                        // totalSquareCount 가 1이 아니면 무조건 틀림
                        if (totalSquareCount == 1 && isCorrect()) {
                            System.out.println("#" + i + " " + "yes");
                            break;
                        }
                        else System.out.println("#" + i + " " + "no");

                    }
                }
            }

        }

    }

    private static boolean isSafe(int x, int y) {
        return 0<=x && x<N && 0<=y && y<N && myMap[x][y] != '.';
    }

    // 가로 세로 숫자 길이가 같고 이를 곱한 숫자가 count 면 정사각형?
    private static void isSquare(int x, int y) {
        visited[x][y] = true;
        count += 1;
        for (int dir=0; dir<4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            if (isSafe(newX, newY) && !visited[newX][newY]) {
                if (newY > checkY) checkY = newY;
                if (newX > checkX) checkX = newX;
                isSquare(newX, newY);
            }
        }

        totalSquareCount++;
    }

    private static boolean isCorrect() {
        int isCorrectX = checkX - startX;
        int isCorrectY = checkY - startY;

        return isCorrectX == isCorrectY && (count == isCorrectX * isCorrectY);
    }
}
