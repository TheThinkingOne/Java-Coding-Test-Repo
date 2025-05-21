package swea.D3.swea1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= 10; i++) {
            int N = Integer.parseInt(br.readLine());
            String aparts = br.readLine();
            List<Integer> list = Arrays.stream(aparts.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int count = 0;

            for (int j=2; j<list.size()-2; j++) { // 1,2 번째랑 , N-1, N번째는 층 아파트 없음

                int currentApt = list.get(j);
                int prevApt = list.get(j-1); // 왼쪽 아파트
                int nextApt = list.get(j+1); // 오른쪽 아파트
                int nextnextApt = list.get(j+2); // 오른오른쪽 아파트
                int prevprevApt = list.get(j-2); // 왼왼쪽 아파트

                if (isCheckable(currentApt, prevApt, nextApt, nextnextApt, prevprevApt))  {
                    int prevMax = Math.max(prevApt, prevprevApt); // 전,전전 아파트 중 더 높은거
                    int nextMax = Math.max(nextApt, nextnextApt); // 다음, 다다음 아파트 중 더 높은거

                    if(prevMax == nextMax) { // 차이가 같은경우
                        count += currentApt - prevMax;
                    } else {
                        count += currentApt - Math.max(prevMax, nextMax);
                    }
                }
            }

            System.out.println("#" + i + " " + count);
        }
    }

    private static boolean isCheckable(int currentApt, int prevApt, int prevprevApt, int nextApt, int nextnextApt) {
        // 현재 아파트보다 좌우 2칸씩의 아파트가 자기보다 크거나 같으면 무조건 나가리
        if (currentApt <= prevApt || currentApt <= prevprevApt || currentApt <= nextApt || currentApt <= nextnextApt) {
            return false;
        } else {
            return true;
        }
    }
}
