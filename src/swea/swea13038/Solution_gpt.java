package swea.swea13038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_gpt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            List<Integer> days = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int needed = Integer.parseInt(st.nextToken());  // 필요한 수업 일수
            int classInFullWeek = 0;  // 일주일 중 수업이 있는 요일의 수

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int day = Integer.parseInt(st.nextToken());
                classInFullWeek += day;  // 수업이 있는 날을 카운트
                days.add(day);  // 요일별 수업 여부를 리스트에 추가
            }

            int temp = Integer.MAX_VALUE;

            for (int j = 0; j < 7; j++) {
                if (days.get(j) == 1) {  // 수업이 있는 날만 개강으로 잡음, 이래야 제일 효율적일것
                    int currentNeeded = needed;
                    int totalDays = 0;  // 총 흘러간 일 수
                    int start = j;  // 현재 개강일 시작 지점

                    // 수업을 들으면서 필요한 수업 일수를 채울 때까지 반복
                    while (currentNeeded > 0) {
                        if (days.get(start % 7) == 1) {  // 수업이 있는 날인 경우(일주일 7 나누기)
                            currentNeeded--;  // 남은 수업 일수를 하나 줄임
                        }
                        totalDays++;  // 총 흘러간 일수 증가
                        start++;  // 다음요일로 이동
                    }

                    temp = Math.min(temp, totalDays);
                }
            }

            System.out.println("#" + i + " " + temp);
        }
    }
}

