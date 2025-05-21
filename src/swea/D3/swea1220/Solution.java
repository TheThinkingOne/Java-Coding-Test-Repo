package swea.D3.swea1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int TC=1; TC<=10; TC++) {

            int N = Integer.parseInt(br.readLine());
            int[][] myMap = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    myMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }





        }
    }
}
