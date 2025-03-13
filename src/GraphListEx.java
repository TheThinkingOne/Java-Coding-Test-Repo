import java.util.ArrayList;

public class GraphListEx {
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        int numVertices = 5; // 그래프의 정점 수

        // 배열 초기화
        graph = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 추가 (예: 무방향 그래프)
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(3, 4);

        // 그래프 출력
        printGraph();
    }

    static void addEdge(int u, int v) {
        graph[u].add(v);
        graph[v].add(u); // 무방향 그래프의 경우 반대 방향도 추가
    }

    static void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print("Vertex " + i + ":");
            for (int neighbor : graph[i]) {
                System.out.print(" " + neighbor);
            }
            System.out.println();
        }
    }
}
