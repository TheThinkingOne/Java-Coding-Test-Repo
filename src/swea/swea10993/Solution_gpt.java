package swea.swea10993;

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

            ArrayList<ArrayList<Integer>> cityList = new ArrayList<>();
            List<String> organizationList = new ArrayList<>(); // 체제 담는 리스트

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 도시의 개수
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                ArrayList<Integer> city = new ArrayList<>();
                int x = Integer.parseInt(st.nextToken()); // x좌표
                int y = Integer.parseInt(st.nextToken()); // y좌표
                int si = Integer.parseInt(st.nextToken()); // 해당 도시의 영향력

                city.add(x); city.add(y); city.add(si);
                city.add(j + 1); // 해당 도시의 번호(인덱스)
                cityList.add(city);
            }

            for (int j = 0; j < N; j++) {
                ArrayList<Integer> currentCity = cityList.get(j); // 현재 도시 뽑아오기
                int currentX = currentCity.get(0);
                int currentY = currentCity.get(1);
                int currentSI = currentCity.get(2);

                float maxInfluence = 0;
                String maxInfluenceCityIndex = "";
                boolean multipleMaxInfluences = false;

                for (int k = 0; k < N; k++) {
                    if (j == k) continue; // 자기 자신을 비교하지 않음

                    int otherX = cityList.get(k).get(0); // 비교 도시의 x좌표
                    int otherY = cityList.get(k).get(1); // 비교 도시의 y좌표
                    int otherSI = cityList.get(k).get(2);

                    int diffX = (currentX - otherX) * (currentX - otherX);
                    int diffY = (currentY - otherY) * (currentY - otherY);
                    float influence = (float) otherSI / (diffX + diffY);

                    if (influence > currentSI) { // 다른 도시가 현재 도시를 위협하는 경우
                        if (influence > maxInfluence) {
                            maxInfluence = influence;
                            maxInfluenceCityIndex = String.valueOf(cityList.get(k).get(3));
                            multipleMaxInfluences = false; // 새로운 최대 영향력이므로 단일 위협 도시
                        } else if (influence == maxInfluence) {
                            multipleMaxInfluences = true; // 최대 영향력 도시가 여러 개
                        }
                    }
                }

                if (maxInfluence == 0) {
                    // 어떠한 도시에도 위협받지 않는 경우 군주제(K)
                    organizationList.add("K");
                } else if (multipleMaxInfluences) {
                    // 최대 영향력 도시가 여러 개인 경우 공화제(D)
                    organizationList.add("D");
                } else {
                    // 단일 위협 도시가 있는 경우 해당 도시를 따름
                    organizationList.add(maxInfluenceCityIndex);
                }
            }

            System.out.print("#" + i + " ");
            for (String org : organizationList) {
                System.out.print(org + " ");
            }
            System.out.println();
        }
    }
}
