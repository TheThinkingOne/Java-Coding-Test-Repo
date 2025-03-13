package Implementation.boj5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int n, k;
    static String[] arr;
    static int[] check;
    static StringBuilder temp;
    static Set<String> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        check = new int[n];
        temp = new StringBuilder();
        result = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().trim();
        }

        card(0);
        System.out.println(result.size());
    }

    static void card(int N) {
        if (N == k) {
            result.add(temp.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i] != 0) {
                continue;
            }

            check[i] = 1;
            temp.append(arr[i]);

            card(N + 1);

            check[i] = 0;
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}


