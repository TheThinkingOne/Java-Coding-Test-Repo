package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea14178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=0; i<TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            // N=5, D=1 일때 2,4 에 배치
            // N=5, D=2 일때 3 에 배치
            int ran = D * 2 + 1;
            int count = 0;
            while (true) {
                count++;
                int condition = ran * count;
                if (N <= condition) break;
            }

            System.out.println("#" + (i+1) + " " + count);

        }

    }
}
