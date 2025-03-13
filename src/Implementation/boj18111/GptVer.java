package Implementation.boj18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GptVer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 세로
        int M = Integer.parseInt(st.nextToken()); // 가로
        int B = Integer.parseInt(st.nextToken()); // 인벤토리 안에 있는 블록 수

        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        int maxHeight = 0; // 최대 높이
        int minHeight = 256; // 최소 높이 (블록의 높이는 0부터 255까지이므로 초기값을 256으로 설정)

        // 맵의 최대 높이와 최소 높이를 찾음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                row.add(height);
                maxHeight = Math.max(maxHeight, height);
                minHeight = Math.min(minHeight, height);
            }
            map.add(row);
        }

        int minTime = Integer.MAX_VALUE;

        // 맵의 최소 높이부터 최대 높이까지 각 높이에 대해 시간을 계산하여 최소값을 구함
        for (int targetHeight = minHeight; targetHeight <= maxHeight; targetHeight++) {
            int time = 0;
            int inventory = B; // 현재 인벤토리 안에 있는 블록 수
            int blocksToBuild = 0; // 맞춰야 하는 블록 수

            // 현재 높이로 모든 블록을 맞출 때 필요한 시간 계산
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int heightDiff = map.get(i).get(j) - targetHeight; // 현재 위치의 높이와 목표 높이의 차이
                    if (heightDiff > 0) {
                        time += heightDiff * 2; // 목표 높이에 맞추는 시간 추가
                        inventory += heightDiff; // 인벤토리에 추가되는 블록 수 갱신
                    } else {
                        time += -heightDiff; // 목표 높이에 맞추는 시간 추가
                        blocksToBuild -= heightDiff; // 맞춰야 하는 블록 수 갱신
                    }
                }
            }

            // 모든 블록을 맞출 때 필요한 시간 계산
            if (inventory >= blocksToBuild) { // 인벤토리에 충분한 블록이 있는 경우
                time += blocksToBuild; // 모든 블록을 맞추는 시간 추가
                minTime = Math.min(minTime, time); // 최소 시간 갱신
            } else { // 인벤토리에 충분한 블록이 없는 경우
                continue; // 해당 높이로는 맞출 수 없으므로 다음 높이로 진행
            }
        }

        System.out.println(minTime + " " + minHeight);
    }
}
