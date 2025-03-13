package Implementation.shortestdistance.boj6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RefactorVEr {

    static final int INF = 987654321;
    static List<List<Integer>> myMap;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        myMap = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            myMap.add(new ArrayList<>());
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            myMap.get(A).add(B);
            myMap.get(B).add(A);
        }

        /*1: [3, 2]
        2: [3, 1, 4, 5]
        3: [6, 4, 2, 1]
        4: [3, 2]
        5: [2]
        6: [3]*/


        int start = 1;
        distance[start] = 0;

        for (int i = 1; i <= N; i++) {
            int current = getMinNode(N);
            if (current == -1) break;
            visited[current] = true;

            for (int next : myMap.get(current)) {
                // 이 문제에선 길이 있는 경우 코스트가 1 이므로
                if (!visited[next] && distance[current] + 1 < distance[next]) {
                    distance[next] = distance[current] + 1;
                }
            }

            /*첫번째로 getMinNode 를 실행하고 minindex = 1 을 받아서 for (int next : myMap.get(current)) {
                // 이 문제에선 길이 있는 경우 코스트가 1 이므로
                if (!visited[next] && distance[current] + 1 < distance[next]) {
                    distance[next] = distance[current] + 1;
                }
            }이 부분을 통해 distance[2] 가 1이 되는거구나. 그렇게 해서 재귀를 통해 다익스트라를 갱신하는거고.*/
        }

        int maxDistance = 0;
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

