package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj1149 {
    static int N;
    static int Red = 0;
    static int Green = 1;
    static int Blue = 2;

    static int[][] myMap;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        myMap = new int[N][3]; // 색깔 가격의 정보를 담을 myMap 배열
        dp = new int[N][3]; // 다이나믹 프로그래밍을 위한 배열

        // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화

//        for (int i=0; i<N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j=0; j<N; j++) {
//                int num = Integer.parseInt(st.nextToken());
//                myMap[i][j] = num;
//            }
//        }
        for (int i=0; i<N; i++) {
            //st = new StringTokenizer(br.readLine());
            // Red = 0, Green = 1; Blue = 2;
            myMap[i][Red] = sc.nextInt();
            myMap[i][Green] = sc.nextInt();
            myMap[i][Blue] = sc.nextInt();
        }

        // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        dp[0][Red] = myMap[0][Red];
        dp[0][Green] = myMap[0][Green];
        dp[0][Blue] = myMap[0][Blue];

        int sum = 0;


        System.out.print(Math.min(PaintingCost(N- 1, Red), Math.min(PaintingCost(N - 1, Green), PaintingCost(N - 1, Blue))));
        // https://st-lab.tistory.com/128
    }
//    private static boolean isSafe(int y, int x) {
//        return 0<y && y<N && 0<x && x<N;
//    }
    private static int PaintingCost(int N, int color) {
        if(dp[N][color] == 0) {

            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
            if(color == Red) {
                dp[N][Red] = Math.min(PaintingCost(N - 1, Green), PaintingCost(N - 1, Blue)) + myMap[N][Red];
            }
            else if(color == Green) {
                dp[N][Green] = Math.min(PaintingCost(N - 1, Red), PaintingCost(N - 1, Blue)) + myMap[N][Green];
            }
            else {
                dp[N][Blue] = Math.min(PaintingCost(N - 1, Red), PaintingCost(N - 1, Green)) + myMap[N][Blue];
            }

        }
        return dp[N][color];
    }
}
