package swea.swea9839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_correct {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력
        for (int i = 0; i < TC; i++) {
            int N = Integer.parseInt(br.readLine()); // 숫자의 개수 입력

            int[] numbers = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine()); // 숫자 리스트 입력 (한 줄)

            for (int j = 0; j < N; j++) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            int result = -1; // 결과값 초기화

            // 두 숫자의 곱 계산 및 체크
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int mul = numbers[j] * numbers[k];
                    if (check(mul)) {
                        result = Math.max(result, mul); // 가장 큰 값 업데이트
                    }
                }
            }

            // 결과 출력
            System.out.println("#" + (i + 1) + " " + result);
        }
    }

    // 연속된 숫자인지 확인하는 함수
    private static boolean check(int num) {
        int prev = -1;
        while (num > 0) {
            if (prev != -1 && prev - 1 != num % 10) { // 현재 자릿수가 이전 자릿수보다 1 작지 않으면,
                // 연속되지 않았다고 판단하고 false 반환
                return false;
            }
            prev = num % 10;
            num /= 10;
        }
        return true;
    }
}
