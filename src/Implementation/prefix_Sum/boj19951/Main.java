package Implementation.prefix_Sum.boj19951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 연병장 크기
        int M = Integer.parseInt(st.nextToken()); // 조교 수

        int[] myMap = new int[N + 1];
        int[] preFix = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            myMap[i] = Integer.parseInt(st.nextToken());
            preFix[i] = myMap[i] + preFix[i - 1];
        }

        //System.out.println(Arrays.toString(preFix));

        int tempStart = 0; int tempEnd = 0; int tempHeight = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            tempHeight = start;
            tempEnd = end;
            tempHeight = height;

        }


    }
}
