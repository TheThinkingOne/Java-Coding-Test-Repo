package swea.D3.swea1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int TC = 1; TC <= 10; TC++) {
            br.readLine();

            String find = br.readLine();
            String line = br.readLine();
            char[] lineCharArr = line.toCharArray();

            int count = 0;

            for (int i = 0; i <= lineCharArr.length - find.length(); i++) { // 범위 이거도 문제였었음
                StringBuilder sb = new StringBuilder();  // 매번 새로 초기화(여기가 문제였었음)

                for (int j = i; j < i + find.length(); j++) { // 이건 맞았음
                    sb.append(lineCharArr[j]);
                }

                if (sb.toString().equals(find)) {
                    count++;
                }
            }

            System.out.println("#" + TC + " " + count);
        }
    }
}

