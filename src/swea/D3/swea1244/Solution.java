package swea.D3.swea1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=1; i<=TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken()); // 무조건 M 만큼 교환 이뤄져야 함

            String N_str = String.valueOf(N);
            List<Integer> N_list = Arrays.stream(N_str.split(""))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> N_list_sort = N_list;
            Collections.sort(N_list_sort);
            Collections.reverse(N_list_sort);

            StringBuilder builder = new StringBuilder();
            for (int k : N_list_sort) {
                builder.append(k);
            }
            int builderNum = Integer.parseInt(builder.toString()); // 최대 숫자

            for (int j=1; j<=M; j++) {

            }


        }
    }
}
