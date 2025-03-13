package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        br.close();

        int temp = 1;
        int sum = 0;

        for (int i=str.length()-1; i>=0; i--) {
            char c = str.charAt(i);

            if ('A' < c && c <= 'z') {
                sum += (c-'A'+10) * temp;
            }
            else {
                sum += (c - '0') * temp;
            }
            temp *= B;
        }

        System.out.println(sum);

    }
}
