package Implementation.two_pointer.boj7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            /*int[] NList = new int[N+1];*/
            ArrayList<Integer> NList = new ArrayList<>();
            ArrayList<Integer> MList = new ArrayList<>();

            st =  new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                NList.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                MList.add(Integer.parseInt(st.nextToken()));
            }

            br.close();

            Collections.sort(NList, Collections.reverseOrder());
            Collections.sort(MList, Collections.reverseOrder());

            int startN = 0;
            //int maxIndex_N = N-1;
            int startM = 0;
            //int maxIndex_M = M-1;

            int count = 0;

            while (startN <= N) {

                if (startM == 0 && startM == 0 && NList.get(startN) > MList.get(startM)) {
                    // 둘다 인덱스가 0이고 왼쪽 첫번째 요소가 오른쪽 첫번쨰 요소보다 크면
                    count += N;
                    startN++;
                    if (startN == N) {
                        break;
                    }
                }

                else {
                    while (true) {
                        if (NList.get(startN) <= MList.get(startM)) {
                            // 오른쪽 요소가 왼쪽보다 크면 continue 넘김
                            continue;
                        } else {
                            count += 1;
                        }
                        startM++;
                        if (startM == M) {
                            startN++;
                            startM=0;
                            break;
                        }
                    }
                }

            }

            System.out.println(count);



        }

    }
}
