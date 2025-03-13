package Implementation.boj16235;

import java.io.*;
import java.util.*;

// N: 맵의 크기
// M: 나무의 개수
// K: K년이 지난 후
// A[r][c]: 추가되는 양분의 양
// x y z: 나무의 위치, 나이

class Tree implements Comparable<TreeClass02> {
    int x, y, age;

    public Tree(int x, int y, int age) {
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

public class googleVer {
    static int[] adj_x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] adj_y = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] robot = new int[N + 1][N + 1]; // 로봇이 주는 양분
        int[][] nourishment = new int[N + 1][N + 1]; // 해당 땅의 양분
        Deque<TreeClass02> tree_list = new LinkedList<>();

        // robot[r][c] 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                robot[i][j] = Integer.parseInt(st.nextToken());
                nourishment[i][j] = 5; // 모든 땅의 초기 양분값은 5
            }
        }

        // 나무 리스트에 추가
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tree_age = Integer.parseInt(st.nextToken());
            tree_list.add(new TreeClass02(x, y, tree_age));
        }

        while (K > 0) {
            Queue<TreeClass02> die_tree_list = new LinkedList<>();

            // 봄
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

            // 여름
            for (TreeClass02 t : die_tree_list) {
                nourishment[t.x][t.y] += t.age / 2;
            }

            // 가을
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

            // 겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    nourishment[i][j] += robot[i][j];
                }
            }

            K--;
        }

        bw.write(tree_list.size() + "\n");
        bw.flush();
        bw.close();
    }
}