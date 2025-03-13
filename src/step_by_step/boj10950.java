package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10950 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수 입력
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스만큼 반복
        for (int i = 0; i < T; i++) {
            // 한 줄에 있는 두 숫자를 공백을 기준으로 나누어 처리
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 결과 출력
            System.out.println(A + B);
        }
    }
}

