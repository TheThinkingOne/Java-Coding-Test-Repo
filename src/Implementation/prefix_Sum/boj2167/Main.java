package Implementation.prefix_Sum.boj2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] myMap = new int[N+1][M+1];
        int[][] preFix = new int[N+1][M+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                myMap[i][j] = Integer.parseInt(st.nextToken());
                preFix[i][j] = myMap[i][j] + preFix[i-1][j]
                        + preFix[i][j-1] - preFix[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i=0; i<K; i++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int start1 = Integer.parseInt(st.nextToken());
            int end1 = Integer.parseInt(st.nextToken());
            int start2 = Integer.parseInt(st.nextToken());
            int end2 = Integer.parseInt(st.nextToken());

            sum = preFix[start2][end2] - preFix[start1-1][end2] - preFix[start2][end1-1] + preFix[start1-1][end1-1];
            System.out.println(sum);
        }

    }
}
