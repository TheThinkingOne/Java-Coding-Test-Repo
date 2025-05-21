package swea.D3.swea23791;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    static Map<Integer, String> map;
    static List<Integer> A_List;
    static List<Integer> B_List;
    static int A_idx;
    static int B_idx;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {

            N = Integer.parseInt(br.readLine());

            String A = br.readLine();
            String B = br.readLine();
            A_List = Arrays.stream(A.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            B_List = Arrays.stream(B.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            map = new LinkedHashMap<>(); // 순서 보존
            A_idx = 0;
            B_idx = 0;

            int turn = 0;
            while (map.size() < N) {
                turn++;
                if (turn % 2 == 1) ATurn();
                else BTurn();
            }

            // 출력
            StringBuilder sb = new StringBuilder();
            for (int k = 1; k <= N; k++) {
                sb.append(map.get(k));
            }
            System.out.println(sb);
        }
    }

    private static void ATurn() {
        while (A_idx < A_List.size()) {
            int i = A_List.get(A_idx++);
            if (!map.containsKey(i)) {
                map.put(i, "A");
                break;
            }
        }
    }

    private static void BTurn() {
        while (B_idx < B_List.size()) {
            int i = B_List.get(B_idx++);
            if (!map.containsKey(i)) {
                map.put(i, "B");
                break;
            }
        }
    }
}
