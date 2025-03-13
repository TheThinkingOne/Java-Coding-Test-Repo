package Implementation.shortestdistance.boj6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int INF = 987654321;

    static int[][] myMap;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        myMap = new int[N+1][N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                myMap[i][j] = (i == j) ? 0 : INF;
            }
            distance[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            myMap[A][B] = 1;
            myMap[B][A] = 1;
        }

        int start = 1;
        distance[start] = 0;

        for (int i = 1; i <= N; i++) {
            int current = getMinNode(N);
            if (current == -1) break; // 더 이상 방문할 노드가 없으면 종료
            visited[current] = true;

            for (int j=1; j<=N; j++) {
                if (!visited[j] && myMap[current][j] != INF && distance[current] + myMap[current][j] < distance[j]) {
                    distance[j] = distance[current] + myMap[current][j];
                }
            }
        }

        int maxDistance = 0;
        //int maxNode = 0;
        List<Integer> nodes = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                nodes.clear();
                nodes.add(i);
            } else if (distance[i] == maxDistance) {
                nodes.add(i);
            }
        }

        int maxNode = Collections.min(nodes);
        int count = nodes.size();

        //가장작은 헛간번호, 거리, 같은 거리의 수 출력
        System.out.println(maxNode + " " + maxDistance + " " + count);


    }

    private static int getMinNode(int N) {
        int min = INF;
        int minIndex = -1;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
