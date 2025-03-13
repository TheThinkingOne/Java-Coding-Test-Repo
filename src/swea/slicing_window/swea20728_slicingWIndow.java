package swea.slicing_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea20728_slicingWIndow {

    static int K;
    static int[] list;
    static int difference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 주머니의 개수
            K = Integer.parseInt(st.nextToken()); // 나눠줄 주머니 개수

            list = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                //st = new StringTokenizer(br.readLine());
                list[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(list);

            difference = Integer.MAX_VALUE;
            for (int j = 0; j <= N - K; j++) {
                int diff = list[j+K-1] - list[j]; // // 연속된 K개의 숫자 중 최대값과 최소값의 차이
                difference = Math.min(difference, diff);
            }

            System.out.println("#" + (i + 1) + " " + difference);

            // https://chatgpt.com/c/6710cced-9898-800f-818f-522ff37c4fb0

        }

    }


}
