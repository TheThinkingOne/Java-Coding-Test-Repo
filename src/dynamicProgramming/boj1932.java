package dynamicProgramming;//package dynamicProgramming;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//public class boj1932 {
//
//
//    static int count;
//    static int sum;
//    static int N;
//    static int maxSum;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        N = Integer.parseInt(br.readLine());
//        sum = 0;
//
//        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
//
//        for (int i=0; i<N; i++) {
//            st = new StringTokenizer(br.readLine());
//            ArrayList<Integer> currentLine = new ArrayList<>();
//            for (int j=0; j<=i; j++) {
//                int num = Integer.parseInt(st.nextToken());
//                currentLine.add(num);
//            }
//            triangle.add(currentLine);
//        }
//
//        sol(0, triangle, count, sum);
//        System.out.println(maxSum);
//    }
//
//    public static void sol(int idx, ArrayList<ArrayList<Integer>> triangle, int count, int sum) {
//
//        for (int i=idx; i<idx+1; i++) {
//            sum += triangle.get(idx).get(i);
//            count += 1;
//            if (count == N) {
//                if (maxSum < sum) {
//                    maxSum = sum;
//                }
//            }
//            sol(idx + 1, triangle, count, sum);
//        }
//
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1932 {
    // DP 생각안하고 한 버전 (시긴초과)
    static int maxSum;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        maxSum = 0;

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> currentLine = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());
                currentLine.add(num);
            }
            triangle.add(currentLine);
        }

        sol(0, 0, triangle, 0);
        System.out.println(maxSum);
    }

    public static void sol(int row, int col, ArrayList<ArrayList<Integer>> triangle, int sum) {
        if (row == N) {
            maxSum = Math.max(maxSum, sum);
            return;
        }

        // 현재 위치의 값 더하기
        sum += triangle.get(row).get(col);

        // 왼쪽 아래 이동
        sol(row + 1, col, triangle, sum);

        // 오른쪽 아래 이동
        sol(row + 1, col + 1, triangle, sum);
    }
}
// https://chat.openai.com/share/2e38726b-16b8-4819-83a7-ff8b4ef4d878
