package swea.swea9940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Set<Integer> set = new TreeSet<>(); // TreeSet 쓰면 자동으로 오름차순 정렬됨

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            System.out.println(set);

            int temp = 1;
            int count = 0;
            String result = "No";

            if (set.size() == N) {
                for (int j : set) {
                    if (j == temp) {
                        count++;
                        temp++;
                    } else break;
                }
            }

            if (count == N) result = "Yes";
            System.out.println("#" + i + " " + result);

        }

    }
}
