package Implementation.two_pointer.boj28353;

import javax.naming.PartialResultException;
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

        int N = Integer.parseInt(st.nextToken()); // N 마리의 고양이
        int M = Integer.parseInt(st.nextToken()); // M 무개 만큼 버틸 수 있음
        ArrayList<Integer> cats = new ArrayList<Integer>();

//        int count = 0;
//        int intervalSum = 0;
//        int end = 0;
//        int totalCount = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(st.nextToken());
            cats.add(weight);
        }

        Collections.sort(cats);
        int answer = 0;

        int min = cats.get(0); // 제일 가벼운놈
        int max = cats.get(cats.size() - 1); // 가장 무거운놈

        int minIndex = 0;
        int maxIndex = N-1;

        while (minIndex < maxIndex) { // 첫 고양이부터 끝 고양이까지 탐색하게 설정
            int temp = min + max;

            if (temp > M) { // 최대 M 만큼의 무개를 한 사람이 견딜 수 있음
                max = cats.get(maxIndex--); // 덜 무거운놈 으로 옮김
            }
            else {
                answer++;
                min = cats.get(minIndex++); // 그다움 더 무거운애로 옮김
                max = cats.get(maxIndex--); // 그다음 더 가벼운애로 옮김
            }
        }

        System.out.println(answer);

        /*for (int start = 0; start < N; start++) {
            while (intervalSum <= M && end < N) {
                intervalSum += cats[end];
                end++;
                count++;
                if (intervalSum <= M && count == 2) {
                    totalCount++;
                }
                intervalSum -= cats[start];
            }

        }*/

        //System.out.println(totalCount);

    }
}

// https://chatgpt.com/share/e169930c-38b7-4f8e-9c39-13a7398ede89
