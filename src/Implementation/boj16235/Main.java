package Implementation.boj16235;

import java.io.*;
import java.util.*;

class TreeClass implements Comparable<TreeClass02> {
    int x, y, age;

    public TreeClass(int x, int y, int age) {
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

public class Main {
    static int N;
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] myMap;
    static int[][] nourish; //양분
    static Deque<TreeClass02> treeList;
    static Queue<TreeClass02> deadTreeList;
    static Queue<TreeClass02> tempList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵 크기 NxN
        int M = Integer.parseInt(st.nextToken()); //
        int K = Integer.parseInt(st.nextToken()); // 지나는 년도

        nourish = new int[N+1][N+1]; // 로봇이 양분을 주는 것의 정보 map
        myMap = new int[N+1][N+1]; // 각 땅의 나무 개수 새는 거
        treeList = new LinkedList<>(); // 각 땅의 여러개의 나무 정보를 저장하는 트리구조

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                while (st.hasMoreTokens()) {
                    nourish[i][j] = Integer.parseInt(st.nextToken());
                    myMap[i][j] = 5;
                }
            }
        }

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int treeAge = Integer.parseInt(st.nextToken()); // z는 나무의 나이
            //myMap[x-1][y-1] = treeAge;
            treeList.add(new TreeClass02(x,y,treeAge));
        }

        while (K > 0) {
            deadTreeList = new LinkedList<>();
            Spring();
            Summer();
            Fall();
            Winter();
            K--;
        }

        bw.write(treeList.size() + "\n");
        bw.flush();
        bw.close();

    }
    static boolean isSafe(int y, int x) {
        return 1 <= y && y <= N && 1 <= x && x <= N;
    }

    private static void Spring() {
        for (int i=0; i< treeList.size(); i++) {
            TreeClass02 currentTree = treeList.poll();
            if (myMap[currentTree.y][currentTree.x] >= currentTree.age) {
                myMap[currentTree.y][currentTree.x] -= currentTree.age;
                // 땅에 양분이 자기 나이보다 충분하다면 양분 흡수
                currentTree.age += 1;
                i++; // 같은땅에 있는 다음 나무로 경우 이동
                treeList.add(currentTree);
            } else deadTreeList.add(currentTree);
            // 양분이 충분하지 않다면 그 나무는 죽고 deadTreeList 에 넣음(양분으로 삼기위함)
        }
    }

    private static void Summer() {
        for (TreeClass02 t : deadTreeList) {
            myMap[t.y][t.x] += t.age / 2;
        }
    }

    private static void Fall() {
        tempList = new LinkedList<>();
        for (TreeClass02 t: treeList) {
            if (t.age % 5 == 0) {
                tempList.add(t);
            }
        }
        while (!tempList.isEmpty()) {
            TreeClass02 t = tempList.poll();
            for(int dir = 0; dir<8; dir++) {
                int nextY = t.y + dy[dir];
                int nextX = t.x + dx[dir];
                if (isSafe(nextY, nextX)) {
                    treeList.addFirst(new TreeClass02(nextX,nextY,1));
                }
            }
        }
    }

    private static void Winter() {
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                myMap[i][j] += nourish[i][j];
            }
        }
    }

}
