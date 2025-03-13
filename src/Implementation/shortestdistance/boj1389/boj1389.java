package Implementation.shortestdistance.boj1389;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj1389 {
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] friends = new int[N+1][N+1];
        //boolean[][] visited = new boolean[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                friends[i][j] = INF;

                if (i == j) {
                    friends[i][j] = 0;
                }
            }
        }

        for (int i=0; i<M; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            friends[num1][num2] = 1;
            friends[num2][num1] = 1;
        }

//        for (int i=0; i<N; i++) {
//            int count = 0;
//            for (int j=0; j<N; j++) {
//                if (friends[i][j] == 1) {
//                    count += 1;
//                    visited[i][j] = true;
//
//                }
//            }
//        }
        for (int k=1; k<=N; k++) {
            for (int i=1; i<=N; i++) {
                for (int j=1; j<=N; j++) {
                    // 최단경로 초기화 이 부분 좀 공부해야할듯
//                    if (friends[i][j] == 1 && friends[k][j] == 1) {
//
//                    }
                    if (friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }

        int result = 0;
        int index = -1;

        // 케빈 베이컨의 수가 가장 작은 인덱스를 탐색
        for (int i = 1; i <= N; i++) {
            int total = 0;
            for (int j = 1; j <= N; j++) {
                total += friends[i][j];
            }

            if (result > total) {
                result = total;
                index = i;
            }
        }

        System.out.println(index);

        sc.close();


    }
}
