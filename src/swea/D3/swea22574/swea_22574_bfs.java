package swea.D3.swea22574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_22574_bfs {
    static class State {
        int floor; // 현재 층
        int step;  // 현재 단계

        State(int floor, int step) {
            this.floor = floor;
            this.step = step;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 선택 기회 수
            int P = Integer.parseInt(st.nextToken()); // 금지된 층수

            // BFS를 위한 큐
            Queue<State> queue = new LinkedList<>();
            queue.add(new State(0, 1)); // 0층에서 시작, 1단계부터 시작

            int maxFloor = 0;

            while (!queue.isEmpty()) {
                State current = queue.poll();

                // 현재 단계가 N을 넘어가면 종료
                if (current.step > N) {
                    maxFloor = Math.max(maxFloor, current.floor);
                    break;
                }

                // 선택 1: 현재 층에서 멈추는 선택
                queue.add(new State(current.floor, current.step + 1));

                // 선택 2: 현재 층에서 step만큼 올라가는 선택 (단, P층은 금지)
                int nextFloor = current.floor + current.step;
                if (nextFloor != P) {
                    queue.add(new State(nextFloor, current.step + 1));
                }
            }

            System.out.println(maxFloor); // 각 테스트 케이스마다 최대 층 출력
        }
    }
}

