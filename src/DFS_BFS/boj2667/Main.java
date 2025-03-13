package DFS_BFS.boj2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int AptComplex = 0;
    static List<Integer> ConnectedAptList = new ArrayList<>();
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;
    static char[][] MyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        //sc.nextLine(); // Consume the newline character

        MyMap = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            MyMap[i] = br.readLine().toCharArray();
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (MyMap[y][x] == '1' && !visited[y][x]) {
                    int count = bfs(y, x);
                    AptComplex++;
                    ConnectedAptList.add(count);
                }
            }
        }

        Collections.sort(ConnectedAptList);

        System.out.println(AptComplex);
        for (int count : ConnectedAptList) {
            System.out.println(count);
        }

        br.close();
    }

    public static int bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cy = current[0];
            int cx = current[1];
            count++;

            for (int[] dir : directions) {
                int newY = cy + dir[0];
                int newX = cx + dir[1];

                if (isSafe(newY, newX)) {
                    queue.add(new int[]{newY, newX});
                    visited[newY][newX] = true;
                }
            }
        }

        return count;
    }

    public static boolean isSafe(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < N && MyMap[y][x] == '1' && !visited[y][x];
    }
}
