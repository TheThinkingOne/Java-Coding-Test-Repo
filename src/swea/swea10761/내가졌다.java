package swea.swea10761;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내가졌다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 매 1초마다, 로봇은 복도의 양 방향 중 하나로 1미터 걷거나,
        // 자기 위치에 있는 버튼을 누르거나, 아무 것도 하지 않는다.
        // => 1미터 움직이기, 누르기, 아무것도 안하기 전부 다 시간 카운트
        // 두 로봇 모두 1에서 시작
        // 로봇들이 수열에 표시된 순서대로 버튼을 눌러야 함

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 눌러야 하는 버튼수
            int[] sequence = new int[N]; // 눌러야 하는 버튼 정보 담는 배열
            char[] robot = new char[N]; // 해당 차례의 로봇 정보 담는 배열

            for (int j = 0; j < N; j++) {
                robot[j] = st.nextToken().charAt(0);
                sequence[j] = Integer.parseInt(st.nextToken());
            }

            int time = 0;
            int posO = 1; int posB = 1; // 초기위치
            int nextO = 0; int nextB = 0; // 각 로봇의 다음위치

            while (nextO < N && robot[nextO] != 'O') nextO++;
            while (nextB < N && robot[nextB] != 'B') nextB++;

            for (int j = 0; j < N; j++) {

                if (robot[j] == 'O') {
                    int target = sequence[j]; // 현재 눌러야 하는 버튼의 번호
                    int moveTime = Math.abs(target - posO) + 1;
                    time += moveTime;
                    posO = target; // 오랜지 로봇의 위치 변경

                    if (nextB < N) {
                        int targetB = sequence[nextB]; // 파란색 로봇의
                        posB += Math.min(moveTime, Math.abs(targetB - posB)) * Integer.signum(targetB - posB);
                        //
                    }

                    nextO++;
                    while (nextO < N && robot[nextO] != 'O') nextO++;
                }

                else {
                    int target = sequence[j];
                    int moveTime = Math.abs(target - posB) + 1;
                    time += moveTime;
                    posB = target;

                    if (nextO < N) {
                        int targetO = sequence[nextO];
                        posO += Math.min(moveTime, Math.abs(targetO - posO)) * Integer.signum(targetO - posO);
                    }

                    nextB++;
                    while (nextB < N && robot[nextB] != 'B') nextB++;
                }

            }

            System.out.println("#" + i + " " + time);

        }

        br.close();

    }
}
