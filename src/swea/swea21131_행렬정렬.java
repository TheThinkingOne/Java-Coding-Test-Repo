package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea21131_행렬정렬 {

    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스 수 입력

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int answer = 0;

            matrix = new int[N][N];
            boolean[] check = new boolean[N];  // 각 열이 정렬되었는지 확인하는 불린 배열

            // 행렬 입력 받기
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(st.nextToken());
                    if (matrix[0][k] == k + 1) {  // 첫 행의 값이 정렬 상태인지 체크
                        // matrix[0][0]이 1,
                        // matrix[0][1]이 2 이런 식으로 열이 순차적으로 값이 맞는지 확인
                        check[k] = true;
                    }
                }
            }

            // 전치 연산으로 행렬 정렬하는 부분
            while (true) {
                boolean all_Transpose = true; // 모든 열이 정렬되었는지 확인하는 변수

                for (int p = N - 1; p >= 1; p--) {  // 마지막 열부터 체크
                    if (!check[p]) {
                        answer++;  // 전치 연산 횟수 증가
                        all_Transpose = false;

                        // 전치 연산 실행
                        for (int r = p; r >= 1; r--) {
                            int tmp = matrix[0][r];
                            matrix[0][r] = matrix[r][0]; // 전치 (행 열 change)
                            matrix[r][0] = tmp;

                            // 전치 후 상태 체크
                            check[r] = matrix[0][r] == r + 1;
                        }
                    }
                }

                if (all_Transpose) {
                    break;  // 모든 열이 정렬되었으면 반복 종료
                }
            }

            System.out.println(answer);  // 결과 출력
        }
    }
}
