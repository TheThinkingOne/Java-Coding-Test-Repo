package swea.D3.swea22574;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea22574_tree {
    static int maxFloor;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            // 트리
            maxFloor = 0;
            DFS(0,1,N,P);

            System.out.println(maxFloor);


        }

    }

    private static void DFS(int currentFloor, int step, int N, int P) {

        if (step > N) {
            maxFloor = Math.max(maxFloor, currentFloor);
            return;
        }

        // 현재층에서 안 더하고 멈추는 선택지
        DFS(currentFloor,step+1,N,P);

        // 현재의 step 숫자만큼 올라가기(더하기)
        int next = currentFloor + step;
        if (next != P) {
            DFS(currentFloor,step+1,N,P);
        }

    }
}
