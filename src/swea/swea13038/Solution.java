package swea.swea13038;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            List<Integer> days = new ArrayList<>();

            st = new StringTokenizer(br.readLine());

            int needed = Integer.parseInt(st.nextToken());
            int classInFullWeek = 0; // 월~일 중에 수업 있는 일수

            int temp = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int day = Integer.parseInt(st.nextToken());
                classInFullWeek += day;
                days.add(day);
            }

            // 어느 요일부터 시작하느냐가 관건인가
            // 수업 필요일수 100000 일 때
            // 1 0 0 0 1 0 1 의 경우
            // 금요일에 시작한다 가정 => +3
            // 그럼 남은 필요 수업 일수 99998
            // 1주일에 3일 수업 있으니까 99998 / 3 => 33332, 나머지 2
            // (첫주만 월~금 시작 다 때려보고 그 다음주부턴 월요일부터 시작
            // 33332 * 7 = 233324 + 3 = 233327, 나머지 2일 마저 채우려면
            // 월 화 수 목 금 중에서 월,금 수업, 이러면 총5일++ => 233332

            for (int j=0; j<7; j++) {

                int firstWeek = 0; // 시작일 기준으로 일요일까지의 수업 일수
                int totalDays = 0; // 총 흘러간 일 수

                for (int k=j; k<7; k++) {
                    firstWeek += days.get(k);
                }

                totalDays += 7 - j; // 첫 주 만큼의 일수를 총 일수에 더해줘야 함

                needed -= firstWeek; // 남은 수업 수
                int quotient = needed / classInFullWeek; // ex) 99998 / 3 몫
                int remainder = needed % classInFullWeek; // ex) 99998 / 3 나머지
                totalDays += quotient * 7;

                for (int k=0; k<7; k++) { // 남은 일수 계산(월 부터 시작)
                    totalDays++;
                    if (days.get(k) == 1) {
                        remainder -= 1;
                        if (remainder == 0) {
                            break;
                        }
                    }


                }

                temp = Math.min(temp, totalDays);

            }

            System.out.println("#" + i + " " + temp);

        }
    }
}
