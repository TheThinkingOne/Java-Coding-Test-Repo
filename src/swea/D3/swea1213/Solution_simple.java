package swea.D3.swea1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_simple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int TC = 1; TC <= 10; TC++) {
            br.readLine();
            String find = br.readLine();
            String line = br.readLine();

            int count = 0;
            for (int i = 0; i <= line.length() - find.length(); i++) { // 범위 설정해서 안 넘게 막기
                if (line.substring(i, i + find.length()).equals(find)) {
                    count++;
                }
            }

            System.out.println("#" + TC + " " + count);
        }
    }
}

