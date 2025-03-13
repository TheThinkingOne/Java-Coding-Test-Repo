package Implementation.boj9011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GptVer {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int S = Integer.parseInt(br.readLine());
            int[] nums = new int[S];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < S; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            // 결과를 담을 리스트
            List<Integer> result = new ArrayList<>();

            // 리스트에 1부터 S까지 넣기
            for (int j = 1; j <= S; j++) {
                result.add(j);
            }

            // 역순열을 원래 순열로 복원
            int[] original = new int[S];
            boolean isPossible = true;

            for (int j = S - 1; j >= 0; j--) { // 거꾸로 탐색
                int position = nums[j]; // 현재 탐색하는 숫자
                if (position >= result.size()) {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
                original[j] = result.get(position);
                result.remove(position);
            }

            if (isPossible) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < S; j++) {
                    sb.append(original[j]).append(" ");
                }
                System.out.println(sb.toString().trim());
            }
        }
    }
}
