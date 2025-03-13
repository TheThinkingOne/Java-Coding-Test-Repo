package swea.swea9839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            int minIndex = 0;
            int maxIndex = N-1;

            List<Integer> mulList = new ArrayList<>();
            // List<List<Integer>> wholeList = new ArrayList<>();

            while (minIndex < maxIndex) {
                for (int j = minIndex; j < N; j++) {
                    int mul = list.get(j) * list.get(maxIndex);
                    mulList.add(mul);
                    // wholeList.add(mulList);
                    minIndex++;
                }
            }

            // System.out.println(wholeList);

            for (int j = 0; j< mulList.size(); j++) {
                String numStr = String.valueOf(mulList.get(j));
                int[] digits = numStr.chars()
                        .map(Character::getNumericValue)
                        .toArray();

                int temp = digits[0];
                // 최고의 쌍 구해야함
                for (int k = 1; k < digits.length; k++) { // 연속되지 않은 수 리스트 거름망

                    if (temp + 1 != digits[j]) {
                        mulList.remove(j);
                        // flag = false;
                        break;
                    }
                    else {
                        temp = digits[k];
                    }

                }
            }

            // System.out.println(wholeList);

            int tempMul = 0;

            // wholeList 사이즈가 0이면 결과 -1 출력

            if (mulList.isEmpty()) {
                System.out.println("#" + i + " " + -1);
            }

            else {
                for (int j = 0; j < mulList.size(); j++) {
                    int currentMul = mulList.get(j);
                    if (currentMul > tempMul) {
                        tempMul = currentMul;
                    }
                }

                System.out.println("#" + i + " " + tempMul);
            }

        }
    }

}
