package Implementation.boj14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MiriVer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[][] map = new int[H][W];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        // 블록을 채우는 부분(1을 넣어서)
        for (int i = 0; i < W; i++) {
            int block = Integer.parseInt(st.nextToken());
            while (block-- > 0) {
                map[block][i] = 1;
            }
        }

        for (int i = 0; i < H; i++) {
            boolean flag = false;   // 빗물이 고이는 여부
            int temp = 0;   // 고이기 전까지 담을 임시 변수

            for (int j = 0; j < W; j++) {
                if (!flag) {
                    if (map[i][j] == 1) {
                        flag = true;    // 빗물 고이기 시작
                    }
                } else {
                    if (map[i][j] == 0) {
                        temp++;
                    } else if (temp > 0) {  // 빗물 고임
                        result += temp; // 임시로 담은 빗물을 결과값에 합산
                        temp = 0;   // temp 초기화
                    }
                }

                // 마지막 가로 && 빗물이 고임
                if (j == W - 1 && flag && map[i][j] == 1 && temp > 0) {
                    result += temp;
                }
            }
        }

        System.out.println(result);
    }
}
