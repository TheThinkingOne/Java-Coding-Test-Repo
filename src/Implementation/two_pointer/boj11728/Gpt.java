package Implementation.two_pointer.boj11728;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Gpt {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄에 배열 A와 B의 크기 N과 M이 주어집니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 두 번째 줄에 배열 A의 원소가 주어집니다.
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 세 번째 줄에 배열 B의 원소가 주어집니다.
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 저장 배열
        int[] result = new int[N + M];
        int i = 0, j = 0, k = 0;

        // 투 포인터를 사용하여 두 배열 합치기
        while (i < N && j < M) { // N = 4, M = 3
            if (A[i] <= B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }

        // 배열 A의 나머지 요소를 결과 배열에 추가
        while (i < N) {
            result[k++] = A[i++];
        }

        // 배열 B의 나머지 요소를 결과 배열에 추가
        while (j < M) {
            result[k++] = B[j++];
        }

        // 결과를 출력합니다.
        for (int l : result) {
            System.out.print(l + " ");
        }


    }
}
