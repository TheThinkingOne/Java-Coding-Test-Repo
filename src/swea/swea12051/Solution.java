package swea.swea12051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 최대 N판의 게임을 했다,
            // N이 엄청 큰 수(10^15 까지) => BruteForce 공격 불가
            int PD = Integer.parseInt(st.nextToken()); // PD 퍼센트의 게임 이김
            int PG = Integer.parseInt(st.nextToken()); // PG 퍼센트의 게임 이김

            // 최대 N판 했으며, PD, PG 퍼센터의 게임 이김
            // 예를들어 100판 했고 PD, PG 가 각각 1, 50 이라면
            // 1판, 50판 이기게 되었다는 것

            String result = "";

            float PD_div_100 = (float) PD /100;
            float PG_div_100 = (float) PD /100;

            if (PD >= N || PG >= N) {
                result = "Broken";
            }

            if (PD_div_100 > 1 || PG_div_100 > 1) {
                result = "Broken"; // 1 넘으면 말안됨
            }



            // 존재할수가 있냐 아니면 범위내에 있으면 그만인가



            // float min_prob =

            /*float PD_div_N = (float) PD / N;
            float PG_div_N = (float) PG / N;

            float PD_prob = PD_div_N * 100;
            float PG_prob = PG_div_N * 100;

            System.out.println(PD_prob);
            System.out.println(PG_prob);

            String result = "";*/

            /*if (PD_prob > 100 || PG_prob > 100) result = "Broken";
            else if (isTrue(PD_prob) && isTrue(PG_prob)) {
                result = "Possible";
            }*/

            /*System.out.println("#" + i + " " + result);*/

        }

        br.close();

    }

    /*private static boolean isTrue(float probability) {
        if (0<= probability && probability <= 100) return true;
        else return false;
    }*/
}
