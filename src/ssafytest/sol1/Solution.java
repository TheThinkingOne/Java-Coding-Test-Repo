package ssafytest.sol1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        for (int i = 1; i <= TC; i++) {

            int N = sc.nextInt();
            int D = sc.nextInt();
            int X = sc.nextInt();

            int[] list = new int[N];
            for (int j = 0; j < N; j++) {
                list[j] = sc.nextInt();
            }

            int object = list[X-1] -1;
            int sum = object + (N-1) ;

            /*int[] calculateList = new int[N];
            // int object = list[X-1] -1;
            while (calculateList[X-1] + 1 != list[X-1]) {
                for (int j = D; j < N; j++) {
                    calculateList[j] += 1;
                }
                if (calculateList[X-1] +1 == list[X-1]) {break;}
                for (int k = 0; k < D; k++) {
                    calculateList[k] += 1;
                    if (calculateList[X-1] +1 == list[X-1]) {break;}
                }

            }

            System.out.println(Arrays.toString(calculateList));

            int sum = 0;
            for (int j : calculateList) {
                sum += j;
            }

            System.out.println("#" + i + " " + sum);*/


        }
    }
}
