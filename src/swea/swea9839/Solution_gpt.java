package swea.swea9839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_gpt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 숫자 갯수
            List<Integer> list = new ArrayList<>(); // 초기 숫자 담는 리스트

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            int minIndex = 0;
            int maxIndex = N - 1;

            List<Integer> mulList = new ArrayList<>(); // 곱한 숫자를 담는 리스트

            // 투포인터 방식으로 곱셈 결과 리스트 작성
            while (minIndex < maxIndex) {
                for (int j = minIndex; j < maxIndex; j++) {
                    int mul = list.get(j) * list.get(maxIndex);
                    mulList.add(mul);
                }
                minIndex++;
            }

            // 조건에 맞지 않는 값 제거
            Iterator<Integer> iterator = mulList.iterator();
            while (iterator.hasNext()) {
                int num = iterator.next();
                String numStr = String.valueOf(num);
                boolean isSequential = true;

                // 각 자릿수를 확인하여 연속된 숫자인지 체크
                for (int k = 1; k < numStr.length(); k++) {
                    if (numStr.charAt(k) - numStr.charAt(k - 1) != 1) {
                        isSequential = false;
                        break;
                    }
                }

                // 연속된 숫자가 아니면 리스트에서 제거
                if (!isSequential) {
                    iterator.remove();
                }
            }

            // 결과 출력
            if (mulList.isEmpty()) {
                System.out.println("#" + i + " " + -1);
            } else {
                Collections.sort(mulList);
                int max = mulList.get(mulList.size() - 1);
                System.out.println("#" + i + " " + max);
            }
        }
    }
}

