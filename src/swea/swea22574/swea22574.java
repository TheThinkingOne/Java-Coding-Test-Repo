package swea.swea22574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea22574 {

    static int N;
    static int P;
    static int tempCount;
    static int tempCount02;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // T = 3
        // N = 2, P = 2 => N번의 기회, P 층에서 멈추면 폭발
        // N = 2 일때, 2번의 기회동안 i (1 <= i <= 2)번째 선택에서 i층만큼 올라갈지 아니면
        // 멈춰있을지 선택 가능
        // DP?

        /*int[][] array = new int[][];*/

        // 처음엔 0층에서 시작

        // 2 2 일때 +1, +2 해서 3
        // 2 1 일때 +0(stop), +2 해서 2

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 기회 횟수
            P = Integer.parseInt(st.nextToken()); // 피해야할 층수

            /*Stack<Integer> stack = new Stack<>(); // LIFO*/
            Queue<Integer> queue = new LinkedList<>();

            //dp = new int[10^9][10^9];

            tempCount = 0;
            tempCount02 = 0;

            for (int j = 1; j <= N; j++) {
                tempCount += j;
                queue.add(j);
                if (tempCount == P) { // j가 마지막 N 값일때를 따져야 하나
                    tempCount02 = tempCount - queue.poll(); // 15 - 1 = 14
                    tempCount -= j; // 10
                    /*tempCount02 -= queue.poll();*/
                    calculate(j,N,tempCount,tempCount02);

                }
            }

            System.out.println(Math.max(tempCount,tempCount02));

        }
    }

    private static void calculate(int j, int N, int tempCount, int tempCount02) {
        for (int i = N-j+1; i <= N; i++) {
            tempCount += i;
            tempCount02 += i;
        }
    }
}
