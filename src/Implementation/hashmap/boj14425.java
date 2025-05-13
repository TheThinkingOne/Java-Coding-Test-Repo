package Implementation.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        Map<String, Integer> N_Map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            N_Map.put(s, i);
        }

        for (int i = 0; i < M; i++) {
            String current = br.readLine();
            if (N_Map.containsKey(current)) {
                result++;
            }
        }

        System.out.println(result);

    }
}
