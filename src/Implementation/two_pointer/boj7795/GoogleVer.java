package Implementation.two_pointer.boj7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class GoogleVer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer> NList = new ArrayList<>();
            ArrayList<Integer> MList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                NList.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                MList.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(MList);

            int count = 0;

            for (int j = 0; j < N; j++) {
                int start = 0;
                int end = M - 1;
                int idx = 0;

                while (start <= end) {
                    int middle = (start + end) / 2;
                    if (MList.get(middle) < NList.get(j)) {
                        start = middle + 1;
                        idx = middle + 1;
                    } else {
                        end = middle - 1;
                    }
                }
                count += idx;
            }

            System.out.println(count);
        }

        br.close();
    }
}
