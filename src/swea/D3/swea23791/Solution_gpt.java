package swea.D3.swea23791;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution_gpt {

    static Map<Integer, String> map;
    static List<Integer> A_List;
    static List<Integer> B_List;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            int N = Integer.parseInt(br.readLine());

            A_List = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            B_List = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            map = new LinkedHashMap<>(); // 순서 보존
            int A_idx = 0, B_idx = 0;
            boolean isATurn = true;

            while (map.size() < N) {
                if (isATurn) {
                    while (A_idx < A_List.size()) {
                        int candidate = A_List.get(A_idx++);
                        if (!map.containsKey(candidate)) {
                            map.put(candidate, "A");
                            break;
                        }
                    }
                } else {
                    while (B_idx < B_List.size()) {
                        int candidate = B_List.get(B_idx++);
                        if (!map.containsKey(candidate)) {
                            map.put(candidate, "B");
                            break;
                        }
                    }
                }
                isATurn = !isATurn;
            }

            // 출력은 1부터 N까지 순서대로
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                sb.append(map.get(i));
            }
            System.out.println(sb);
        }
    }
}

