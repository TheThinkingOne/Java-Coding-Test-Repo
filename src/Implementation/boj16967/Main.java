package Implementation.boj16967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nums = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(nums.nextToken());
        int W = Integer.parseInt(nums.nextToken());
        int X = Integer.parseInt(nums.nextToken());
        int Y = Integer.parseInt(nums.nextToken());

        int[][] MyMap = new int[H + X][W + Y];

        for (int i = 0; i < H + X; i++) {
            nums = new StringTokenizer(br.readLine());
            for (int j = 0; j < W + Y; j++) {
                MyMap[i][j] = Integer.parseInt(nums.nextToken());
            }
        }

        for (int i = X; i < H; i++) {
            for (int j = Y; j < W; j++) {
                MyMap[i][j] -= MyMap[i - X][j - Y];
            }
        }

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                System.out.print(MyMap[y][x] + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
