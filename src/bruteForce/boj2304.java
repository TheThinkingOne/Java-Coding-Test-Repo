package bruteForce;

import java.io.*;
import java.util.*;

public class boj2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st;

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // 위치
            arr[i][1] = Integer.parseInt(st.nextToken()); // 높이
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        // col = {{5, 10}, {2, 15}, {8, 5}} 이라면
        // col = {{2, 15}, {5, 10}, {8, 5}} : 정렬후

        // (2,4) (4,6), (5,3) (8,10) (11,4) (13,6) (15,8)

        int area = 0;
        for(int i=0; i < N;) {
            int j = i+1;
            int max = j;
            while( j<N && arr[i][1] > arr[j][1] ){
                if(arr[max][1] < arr[j++][1]) max = j-1;
            }

            if(j>=N){
                area+=arr[i][1];
                if(max<N) area += arr[max][1]*(arr[max][0]-arr[i][0]-1);
                i = max;
            }else {
                area += arr[i][1] * (arr[j][0] - arr[i][0]);
                i = j;
            }
        }

        System.out.println(area);
    }
}
