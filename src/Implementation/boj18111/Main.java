package Implementation.boj18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 인벤토리 안에 있는 블록 수

        // ArrayList<ArrayList<Integer>> MyMap = new ArrayList<>();
        // ArrayList<Integer> arrayList = new ArrayList<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int minCount = 0;
        int maxCount = 0;
        int timeCount = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int height = Integer.parseInt(st.nextToken());
                // arrayList.add(height);
                if (height > max) {
                    max = height;
                }
                if (height == max) maxCount += 1;
                if (height < min) {
                    min = height;
                }
            }
        }

        minCount = N*M - maxCount;
        if (B >= minCount) {
            timeCount += minCount;
            System.out.print(timeCount + " ");
            System.out.println(max);
        }
        else {
            timeCount += maxCount*2;
            System.out.print(timeCount + " ");
            System.out.println(min);
        }
    }
}
