package step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arrayList = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int currentIndex = 0;

        while (true) {
            String line = br.readLine();

            if (line == null || line.isEmpty()) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                arrayList.add(num);

                // 최댓값을 찾아서 인덱스 저장
                if (num > max) {
                    max = num;
                    maxIndex = currentIndex;
                }

                currentIndex++;
            }
        }

        System.out.println(max);        // 최댓값 출력
        System.out.println(maxIndex + 1);  // 최댓값이 몇 번째 수인지 출력 (1부터 시작이므로 +1)
    }
}

