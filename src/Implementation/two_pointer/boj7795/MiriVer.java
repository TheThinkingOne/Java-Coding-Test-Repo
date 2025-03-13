package Implementation.two_pointer.boj7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MiriVer {

    static int p1, p2, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] nArr = new int[N];
            int[] mArr = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                mArr[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 정렬
            Arrays.sort(nArr);
            Arrays.sort(mArr);

            p1 = 0; p2 = 0; count = 0;

            // p1을 기준으로, p1이 N보다 작을 경우에만 반복
            while (p1 < N) { // N=5, M=3
                // A가 B를 먹을 수 있음
                if (nArr[p1] > mArr[p2]) {
                    count++;
                    p2++;

                    if (p2 == M) { // 다 탐색함
                        init();
                    }

                }
                // A가 B를 먹을 수 없음
                else {
                    init();
                }
            }

            System.out.println(count);
        }
    }

    // 새로 탐색 => 왼쪽이 더 작거나 오른쪽 크기만큼 다 탐색하면 넘어가기 위한 메서드
    static void init() {
        p1++;
        p2 = 0;
    }

    // 두 배열 다 오름차순으로 정렬했음으로 왼쪽 값이 오른쪽 값보다 작거나 같으면 바로 다음 p1으로 넘기면 됨
}
/*
1 1 3 7 8
1 3 6
 */
