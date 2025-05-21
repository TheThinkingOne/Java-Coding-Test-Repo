package swea.D3.swea22979;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_another {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int t = 0; t < TC; t++) {
            String s = br.readLine();
            int k = Integer.parseInt(br.readLine());
            String[] ops = br.readLine().split(" ");

            int netShift = 0;
            for (String op : ops) {
                netShift += Integer.parseInt(op); // 전부 더함
            }

            int len = s.length();
            netShift %= len; // 문자열 길이 초과 방지

            if (netShift > 0) {
                s = s.substring(netShift) + s.substring(0, netShift); // 앞 자르기 → 뒤로 보내기
            } else if (netShift < 0) {
                netShift = -netShift;
                s = s.substring(len - netShift) + s.substring(0, len - netShift); // 뒤 자르기 → 앞으로 붙이기
            }

            System.out.println(s);
        }
    }
}

