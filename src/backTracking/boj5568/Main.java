package backTracking.boj5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    private int N, K;
    private int[] check;
    private String[] arr;
    private Set<String> result = new HashSet<>(); // 중복 조합을 없애기 위한 세트형

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        check = new int[N];
        arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().trim();
        }

        card(0, "");

        System.out.println(result.size());
    }

    private void card(int depth, String current) {
        if (depth == K) {
            result.add(current);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i] == 1) {
                continue;
            }
            check[i] = 1;
            card(depth + 1, current + arr[i]);
            check[i] = 0;
        }
    }
}


