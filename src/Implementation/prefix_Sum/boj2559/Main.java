package Implementation.prefix_Sum.boj2559;

import java.util.*;
import java.io.*;

public class Main {
    // 누적합으로 구한 버전
    static int abyss = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] myMap = new int[N+1];
        int[] prefix = new int[N+2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            myMap[i] = Integer.parseInt(st.nextToken());
            prefix[i] = myMap[i] + prefix[i-1];
        }

        //System.out.println(Arrays.toString(prefix));

        /*int temp = 0;
        int sum = abyss;
        for (int i = 1; i <= N-K; i++) {
            //sum = prefix[i+1] - prefix[i] + prefix[i+2] - prefix[i+1];
            temp = prefix[i+K] - prefix[i];
            if (temp >= sum) sum = temp;
        }
        System.out.println(sum);*/

        int sum = abyss;
        for (int i = 0; i <= N - K; i++) {
            int temp = prefix[i + K] - prefix[i];
            if (temp > sum) sum = temp;
        }

        System.out.println(sum);

        //System.out.println(Arrays.toString(prefix));
        //st = new StringTokenizer(br.readLine());

    }
}
