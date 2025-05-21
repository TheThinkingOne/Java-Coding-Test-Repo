package swea.D3.swea5642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution { // 카데인 알고리즘으로 풀린거
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {

            int N = Integer.parseInt(br.readLine()); // N <= 1000
            String line = br.readLine();

            List<Integer> list = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

//            int sum = 0;
//            int all_sum = 0;
//            for (int j : list) all_sum += j;
//
//            for (int j = 0; j < list.size(); j++) {
//                if (j > 0) {
//
//                }
//            }
            int maxSum = Integer.MIN_VALUE;
            int currentSum = 0;

            for (int num : list) {
                currentSum = Math.max(num, currentSum + num);
                // Math.max(1, 0+1) = 1
                // Math.max(3, 1+3) = 4
                // Math.max(-8, 4+(-8)) = -4
                // Math.max(18, -4+18) = 18 => 정답
                // Math.max(18, 18+(-8)) = 10
                maxSum = Math.max(maxSum, currentSum);
            }

            System.out.println("#" + i + " " + maxSum);
        }
    }
}
