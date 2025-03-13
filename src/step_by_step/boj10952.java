package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10952 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        while (true) {
            // while true를 사용해서 입력값이 유효한 경우에만 StringTokenizer 를 사용해 두 숫자를 입력받은 거구나
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) {
                break; // 입력이 0, 0이면 반복문 종료
            }

            System.out.println(A + B);
        }
    }
}
