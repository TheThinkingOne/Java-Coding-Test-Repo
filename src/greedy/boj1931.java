package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        int[][] time = new int[TC][2];

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            time[i][0] = start; // 시작시간
            time[i][1] = end; // 종료시간
        }

        // // 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0]; // 종료시간 같으면 시작시간 비교
                }

                return o1[1] - o2[1]; // 종료시간 비교
            }
        }); // 2중 for문 처럼 비교함

        int count = 0;
        int prev_end_time = 0;

        for(int i = 0; i < TC; i++) {

            // 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신
            if(prev_end_time <= time[i][0]) {
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(Arrays.deepToString(time));
        System.out.println(count);


        /*System.out.println(Arrays.toString(startArr));
        System.out.println(Arrays.toString(endArr));*/


        /*for (int i = 0; i < TC; i++) {

            int tempStart = 0;
            int tempEnd = 0;
            int count = 0;

            for (int j = i; j < TC; j++) {
                int currentStart = startArr[j];
                int currentEnd = endArr[j];

                tempEnd = currentEnd;

                if ( ) {

                }

            }

        }*/


    }
}
