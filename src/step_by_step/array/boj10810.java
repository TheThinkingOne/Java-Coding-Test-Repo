package step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N = 바구니갯수 5
        int M = Integer.parseInt(st.nextToken()); // M = 시도 횟수 4
        int[] basket = new int[N];

        for (int i=1; i<=M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            for (int j=(a-1); j<b; j++) {
                basket[j] = c;
            }

        }

        for (int i=0; i<N; i++) {
            System.out.print(basket[i] + " ");
        }

    }
}
