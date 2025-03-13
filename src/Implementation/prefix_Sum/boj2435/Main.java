package Implementation.prefix_Sum.boj2435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int verySmall = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] myMap = new int[N + 1];
        int[] preFix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i=1 ; i<=N ; i++) {
            myMap[i] = Integer.parseInt(st.nextToken());
            preFix[i] = myMap[i] + preFix[i-1];
        }

        int sum = verySmall;
        for (int i=0; i<=N-K; i++) {
            int temp = preFix[i+K] - preFix[i];
            if (temp >= sum) sum = temp;
        }

        System.out.println(sum);

    }
}
