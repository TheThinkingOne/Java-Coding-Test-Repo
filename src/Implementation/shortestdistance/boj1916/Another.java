package Implementation.shortestdistance.boj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Another {
    static final int INF = 987654321;

    static int[][] myMap;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        myMap = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        // 그래프와 거리 배열 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    myMap[i][j] = 0;
                } else {
                    myMap[i][j] = INF;
                }
            }
            distance[i] = INF;
        }

        // 간선 읽어오기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            myMap[start][end] = cost;
        }

        int startPoint = Integer.parseInt(br.readLine());
        int destination = Integer.parseInt(br.readLine());

        // Initialize the starting point
        distance[startPoint] = 0;

        // Dijkstra's algorithm
        for (int i = 1; i <= N; i++) {
            int current = getMinNode(N);
            if (current == -1) break;  // If there is no reachable node

            visited[current] = true;

            for (int j = 1; j <= N; j++) {
                if (!visited[j] && myMap[current][j] != INF && distance[current] + myMap[current][j] < distance[j]) {
                    distance[j] = distance[current] + myMap[current][j];
                }
            }
        }

        System.out.println(distance[destination]);
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
