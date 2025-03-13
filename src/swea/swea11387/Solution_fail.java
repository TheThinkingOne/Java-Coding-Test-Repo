package swea.swea11387;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken()); // 기본 데미지
            int L = Integer.parseInt(st.nextToken()); // 공격레벨
            int N = Integer.parseInt(st.nextToken()); // 공격횟수

            int totalDmg = 0;

            for (int j = 0; j < N; j++) {
                totalDmg += (int) (D * (1+j*L*0.01));
            }

            System.out.println("#" + i + " " + totalDmg);

        }

        // 테스트 케이스가
        // 1
        //250 7 50 일때
        // 결과 => 33922

    }
}
