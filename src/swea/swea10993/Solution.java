package swea.swea10993;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {

            ArrayList<ArrayList<Integer>> cityList = new ArrayList<>();
            ArrayList<Integer> city;
            List<String> organizationList = new ArrayList<>(); // 체제 담는 리스트

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 도시의 개수
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                city = new ArrayList<>();

                int x = Integer.parseInt(st.nextToken()); // x좌표
                int y = Integer.parseInt(st.nextToken()); // y좌표
                int si = Integer.parseInt(st.nextToken()); // 해당 도시의 영향력

                city.add(x); city.add(y); city.add(si);
                city.add(j+1); // 해당 도시의 번호(인덱스)
                cityList.add(city);

            }

            /*cityList.remove(0);

            System.out.println(cityList);*/

            for (int j = 0; j < N; j++) {
                ArrayList<Integer> currentCity = cityList.get(j); // 현재 도시 뽑아오기
                cityList.remove(j);

                List<Integer> powerList = new ArrayList<>();
                String currentOrganization = "K"; // currentCity 가 따르는 체제
                String tempOrganization = ""; // 임시 기록 체제
                float maxInfluence = 0;
                // K:군주제, D:공화제

                int currentX = currentCity.get(0);
                int currentY = currentCity.get(1);
                int currentSI = currentCity.get(2);

                for (int k=0; k< N-1; k++) {
                    int otherX = cityList.get(k).get(0); // 비교 도시의 x좌표
                    int otherY = cityList.get(k).get(1); // 비교 도시의 y좌표
                    // int otherSI = cityList.get(k).get(2);
                    String otherCityIndex = String.valueOf(cityList.get(k).get(3)); // 비교 도시의 인덱스 번호

                    int diffX = (int) Math.pow(currentX - otherX,2);
                    int diffY = (int) Math.pow(currentY - otherY,2);

                    float influence = (float) currentSI / (diffX + diffY); // 이거 좀 수정해야되나
                    if (influence > maxInfluence) {
                        maxInfluence = influence;
                    }
                    else if (influence == maxInfluence) {
                        currentOrganization = "D";
                    }
                    //if (tempInfluence == influence) currentOrganization = "D";

                    if (influence > currentSI) { // 현재도시의 군사력보다 옆도시 영향력이 쌔면 복종
                        currentOrganization = otherCityIndex;
                        tempOrganization = currentOrganization;
                    }
                    // tempInfluence = influence;
                }

                organizationList.add(currentOrganization);
                cityList.add(j, currentCity);

            }

            System.out.print("#" + i + " ");
            for(String idx : organizationList) {
                System.out.print(idx + " ");
            }

        }
    }
}
