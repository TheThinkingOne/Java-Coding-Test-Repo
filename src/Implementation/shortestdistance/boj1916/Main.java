package Implementation.shortestdistance.boj1916;

import java.util.Scanner;

public class Main {
    static final int INF = 987654321;

    static int[][] myMap;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        myMap = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    myMap[i][j] = 0; // 출발지와 목적지가 같은경우
                } else {
                    myMap[i][j] = INF;
                }
            }
            distance[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            if (cost < myMap[start][end]) {
                // 출발지와 목적지가 같은 경우에 더 비용이 낮은 경로로 설정
                myMap[start][end] = cost;
            }
        }

        int startPoint = sc.nextInt();
        int destination = sc.nextInt();

        distance[startPoint] = 0;

        for (int i = 1; i <= N; i++) {
            int current = getMinNode(N); // 다익스트라로 각 노드별 최소 거리 정리
            // current = minIndex
            if (current == -1) break; // 모든 노드가 방문되었다면 루프 종료

            visited[current] = true;

            for (int j = 1; j <= N; j++) {
                // 방문하지 않았고, 현재 노드와 연결되어 있으며, 새로운 경로가 더 짧다면 거리 갱신
                if (!visited[j] && myMap[current][j] != INF && distance[current] + myMap[current][j] < distance[j]) {
                    distance[j] = distance[current] + myMap[current][j];
                }
            }
        }

        System.out.println(distance[destination]);

        sc.close();
    }

    // 방문하지 않은 노드 중 가장 짧은 거리 값을 가지는 노드 찾기

    // 예제에서 주어진 거리 정보를 다익스트라로 갱신해서
    // (예를들어 1번에서 5번으로 가는 길은 10이엇는데 4로 변경됨) 최소거리를 갱신
    private static int getMinNode(int N) {
        int min = INF;
        int minIndex = -1;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        // N = 1 일때 minIndex = 4
        return minIndex;
    }
}

