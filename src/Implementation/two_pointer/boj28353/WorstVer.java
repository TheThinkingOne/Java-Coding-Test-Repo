package Implementation.two_pointer.boj28353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WorstVer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 고양이의 수
        int M = Integer.parseInt(st.nextToken()); // 버틸 수 있는 최대 무게

        int[] weights = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int maxCount = 0;

        // 모든 두 고양이의 무게 조합을 확인
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (weights[i] + weights[j] <= M) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}

