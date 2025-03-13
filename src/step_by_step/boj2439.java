package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2439 {
    //백준 2438 별 찍기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N-i; j++) {
                System.out.print(" ");
            }
            for (int k=0; k<i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
