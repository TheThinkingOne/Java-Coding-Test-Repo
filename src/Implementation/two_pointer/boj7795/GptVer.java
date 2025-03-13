package Implementation.two_pointer.boj7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class GptVer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
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

            // 내림차순으로 정렬
            Collections.sort(NList, Collections.reverseOrder());
            Collections.sort(MList, Collections.reverseOrder());

            int startN = 0;
            int startM = 0;
            int count = 0;

            while (startN < N) {
                // startM이 유효한 인덱스 범위 내에 있는지 확인
                if (startM < M && NList.get(startN) > MList.get(startM)) {
                    count += (M - startM);
                    startN++;
                } else {
                    startM++;
                    // startM이 M에 도달하면, startN 증가
                    if (startM == M) {
                        startN++;
                    }
                }
            }

            System.out.println(count);
        }

        br.close();
    }
}
