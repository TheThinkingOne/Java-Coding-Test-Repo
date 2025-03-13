package Implementation.boj16235;

import java.io.*;
import java.util.*;

class TreeClass02 implements Comparable<TreeClass02> {
    int x, y, age;

    public TreeClass02(int x, int y, int age) {
        super();
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(TreeClass02 o) {
        return this.age - o.age;
    }
}

//https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-16235-%EB%82%98%EB%AC%B4-%EC%9E%AC%ED%85%8C%ED%81%AC-java

public class FixedVer {
    static int[] adj_x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] adj_y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] robot = new int[N + 1][N + 1];
        int[][] nourishment = new int[N + 1][N + 1];
        Deque<TreeClass02> tree_list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                robot[i][j] = Integer.parseInt(st.nextToken());
                nourishment[i][j] = 5;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tree_age = Integer.parseInt(st.nextToken());
            tree_list.add(new TreeClass02(x, y, tree_age));
        }

        simulateSeasons(N, K, robot, nourishment, tree_list);

        bw.write(tree_list.size() + "\n");
        bw.flush();
        bw.close();
    }

    public static void simulateSeasons(int N, int K, int[][] robot, int[][] nourishment, Deque<TreeClass02> tree_list) {
        while (K > 0) {
            springSummer(nourishment, tree_list);
            //summer(nourishment, tree_list);
            autumn(N, nourishment, tree_list);
            winter(robot, nourishment);
            K--;
        }
    }

    public static void springSummer(int[][] nourishment, Deque<TreeClass02> tree_list) {
        Queue<TreeClass02> die_tree_list = new LinkedList<>();

        for (int i = 0; i < tree_list.size();) {
            TreeClass02 cur = tree_list.poll();
            if (nourishment[cur.x][cur.y] >= cur.age) {
                nourishment[cur.x][cur.y] -= cur.age;
                cur.age++;
                i++;
                tree_list.add(cur);
            } else {
                die_tree_list.add(cur);
            }
        }

        for (TreeClass02 t : die_tree_list) {
            nourishment[t.x][t.y] += t.age / 2;
        }
    }

    public static void autumn(int N, int[][] nourishment, Deque<TreeClass02> tree_list) {
        Queue<TreeClass02> temp_list = new LinkedList<>();
        for (TreeClass02 t : tree_list) {
            if (t.age % 5 == 0) {
                temp_list.add(t);
            }
        }
        while (!temp_list.isEmpty()) {
            TreeClass02 t = temp_list.poll();

            for (int i = 0; i < 8; i++) {
                int next_x = t.x + adj_x[i];
                int next_y = t.y + adj_y[i];
                if (next_x >= 1 && next_x <= N && next_y >= 1 && next_y <= N) {
                    tree_list.addFirst(new TreeClass02(next_x, next_y, 1));
                }
            }
        }
    }

    public static void winter(int[][] robot, int[][] nourishment) {
        for (int i = 1; i < robot.length; i++) {
            for (int j = 1; j < robot[i].length; j++) {
                nourishment[i][j] += robot[i][j];
            }
        }
    }
}


