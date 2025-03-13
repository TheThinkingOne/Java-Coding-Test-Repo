package swea.swea9839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 숫자갯수
            List<Integer> list = new ArrayList<>(); // 초기 숫자 담는 리스트

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            int minIndex = 0;
            int maxIndex = N-1;

            List<Integer> mulList = new ArrayList<>(); // 곱한 숫자듣 담는 리스트

            // 투포인터?
            /*while (minIndex < maxIndex) {
                for (int j = minIndex; j < maxIndex; j++) {
                    int mul = list.get(j) * list.get(maxIndex);
                    mulList.add(mul);
                }
                minIndex++;
            }*/
            while (minIndex < maxIndex) {
                for (int j = minIndex; j < maxIndex; j++) { // 여기서 maxIndex로 루프 범위 수정
                    int mul = list.get(j) * list.get(maxIndex);
                    mulList.add(mul);
                }
                minIndex++;
            }

            System.out.println(mulList);

            // list<

            for (int j=0; j < mulList.size(); j++) {
                String numStr = String.valueOf(mulList.get(j));

                int[] digits = numStr.chars()
                        .map(Character::getNumericValue)
                        .toArray();

                int temp = digits[0]; // 첫 숫자

                // 최고의 쌍 구하기
                for (int k = 1; k < digits.length; k++) {
                    // digits[j] = 현재 숫자
                    if (digits[j] != temp + 1) {
                        mulList.remove(j);
                        break;
                    }
                    else {
                        temp = digits[j];
                    }
                }

            }

            if (mulList.isEmpty()) {
                System.out.println("#" + i + " " + -1);
            }

            else {
                Collections.sort(mulList);
                int max = mulList.getLast();
                System.out.println("#" + i + " " + max);
            }




        }
    }
}
