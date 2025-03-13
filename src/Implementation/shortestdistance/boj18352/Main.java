package Implementation.shortestdistance.boj18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.list;

public class Main {

    static final int INF = 987654321;

    static int N, M, K, X;
    static List<List<Integer>> myMap;
    //static int min = Integer.MAX_VALUE, minIndex;
    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N M K X
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        // K : 문제에서 구하려는 최단 거리 여부
        // X : 출발 노드의 번호

        myMap = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            myMap.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            myMap.get(A).add(B);
        }

        distance = new int[N+1];
        distance[X] = 0;
        visited = new boolean[N+1];

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{X, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentNode = current[0];
            int currentDist = current[1];

            if (currentDist > distance[currentNode]) continue;

            for (int next : myMap.get(currentNode)) {
                if (distance[currentNode] + 1 < distance[next]) {
                    distance[next] = distance[currentNode] + 1;
                    queue.offer(new int[]{next, distance[next]});
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (distance[i] == K) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int city : result) {
                System.out.println(city);
            }
        }

    }

/*    private static int getMinNode(int m) {
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
    }*/

    // 단방향 그래프
    // (1,2) 를 넣고 출발노드를 2로 넘겨서 (2,3), (2,4)를 보고
    // 문제에서 원하는 최단거리가 1인지 2인지 확인?
    // 무조건 다익스트라를 사용해야 하나?


}
