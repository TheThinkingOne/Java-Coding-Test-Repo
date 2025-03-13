package Implementation.two_pointer.boj2531;

//package study0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GptVer { // 백준 2516 회전초밥
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        // ArrayList에 초밥 종류를 담기
        ArrayList<Integer> food = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            food.add(Integer.parseInt(br.readLine()));
        }

        // 초밥의 종류를 카운팅할 배열
        int[] sushiCount = new int[D + 1];
        int uniqueCount = 0;

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < K; i++) {
            int currentSushi = food.get(i);
            if (sushiCount[currentSushi] == 0) {
                uniqueCount++;
            }
            sushiCount[currentSushi]++;
        }

        int maxUniqueCount = uniqueCount;

        // 슬라이딩 윈도우를 이동하면서 최댓값 갱신
        for (int i = 0; i < N; i++) {
            // 이전 접시 제거
            int prevSushi = food.get(i);
            sushiCount[prevSushi]--;
            if (sushiCount[prevSushi] == 0) {
                uniqueCount--;
            }

            // 다음 접시 추가
            int nextSushi = food.get((i + K) % N);
            if (sushiCount[nextSushi] == 0) {
                uniqueCount++;
            }
            sushiCount[nextSushi]++;

            // 쿠폰 초밥 추가 여부 확인
            if (sushiCount[C] == 0) {
                maxUniqueCount = Math.max(maxUniqueCount, uniqueCount + 1);
            } else {
                maxUniqueCount = Math.max(maxUniqueCount, uniqueCount);
            }
        }

        System.out.println(maxUniqueCount);
    }
}

