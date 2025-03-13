package swea.slicing_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea20551_restart {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            System.out.println("#" + i + " " + resolveCandy(first,second,third));
        }
    }

    private static int resolveCandy(int first, int second, int third) {
        int count = 0;
        if (third == 1) return -1;

        if (second >=2 && third >=3) {
            if (second >= third) {
                count += second - third + 1;
                second = third - 1;
            }

            if (first >= second) {
                count += first - second + 1;
                first = second -1;
            }
        }

        else {
            count = -1;
        }

        return count;
    }
}
