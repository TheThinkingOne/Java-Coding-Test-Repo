package swea.D3.swea24001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_gpt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            String s = br.readLine();
            int maxDist = simulate(s.replace('?', 'L')); // ? 전부 L
            maxDist = Math.max(maxDist, simulate(s.replace('?', 'R'))); // ? 전부 R
            System.out.println(maxDist);
        }

    }

    private static int simulate(String s) {
        int point = 0;
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') point--;
            else if (c == 'R') point++;
            max = Math.max(max, Math.abs(point));
        }
        return max;
    }

}
