package swea.swea10761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        // 매 1초마다, 로봇은 복도의 양 방향 중 하나로 1미터 걷거나,
        // 자기 위치에 있는 버튼을 누르거나, 아무 것도 하지 않는다.
        // => 1미터 움직이기, 누르기, 아무것도 안하기 전부 다 시간 카운트
        // 두 로봇 모두 1에서 시작
        // 로봇들이 수열에 표시된 순서대로 버튼을 눌러야 함
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            //Queue<String> queue = new LinkedList<>();
            Queue<Integer> BlueNumList = new LinkedList<>();
            Queue<Integer> OrangeNumList = new LinkedList<>();

            int N = Integer.parseInt(st.nextToken()); // 눌러야 하는 버튼 수
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                String robot = st.nextToken();
                int buttonNum = Integer.parseInt(st.nextToken());
                if (robot.equals("B")) BlueNumList.add(buttonNum);
                else if (robot.equals("O")) OrangeNumList.add(buttonNum);
            }

            int Orange = 1;
            int Blue = 1;
            int time = 0;
            int count = 0;

            while (true) {



                int nextBlueNum = BlueNumList.poll();
                int nextOrangeNum = OrangeNumList.poll();
            }


        }




    }
}
