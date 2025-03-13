package swea.swea13547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea13547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();

            int win = 0;
            int oppertunity = 15;
            String result = "";

            for (int j : chars) {
                if (j == 'o') {
                    win++;
                }
                oppertunity--;
            }

            if (oppertunity + win >= 8) {
                result = "YES";
            } else {
                result = "NO";
            }

            System.out.println("#" + i + " " + result);

        }

    }
}
