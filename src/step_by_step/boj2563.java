package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] myMap = new int[100][100];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int width=x; width<x+10; width++) {
                for (int height=y; height<y+10; height++) {
                    if (myMap[width][height] != 1) {
                        myMap[width][height] = 1;
                    }
                }
            }
        }

        int total = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                total += myMap[i][j];
            }
        }
        System.out.println(total);

    }
}
