package swea.swea10726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); // M의 2진수 표현의 마지막 N비트

            int power = 0; // 제곱
            // 4 30 이면 30의 2진수 표현의 바지막 4비트가 모두 1로 되어있는지 판별?
            while (M >= 1 << power) {
                power++;
            }

            //StringBuilder sb = new StringBuilder();
            ArrayList<Integer> list = new ArrayList<>();
            int realPower = power-1;

            while (M > 1) {

                if (M >= 1 << realPower) {
                    // M -= (int) (M - Math.pow(2,realPower));
                    M -= 1 << realPower;
                    list.add(1);
                    realPower--;
                }

                else {
                    list.add(0);
                    realPower--;
                }

            }

            if (M == 1) list.add(1);
            else if (M == 0) list.add(0);

            int count = 0;
            int temp = 0;
            String result = "OFF";

            if (list.size() >= N) {
                for (int j = list.size() - 1; j >= list.size() - N; j--) {
                    if (list.get(j) == 1) {
                        count++;
                    }
                }
            }

            // System.out.println(count);

            if (count == N) result = "ON";
            System.out.println("#" + i + " " + result);

        }

        br.close();
    }
}
