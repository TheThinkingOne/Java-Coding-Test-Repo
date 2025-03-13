//package Implementation.boj14500;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.StringTokenizer;
//
//public class Main {
//    static int N, M;
//    static int[][] MyMap;
//    static List<Integer> totalSumList = new ArrayList<>();
//
//    static int[] dy = {-1, 1, 0, 0};
//    static int[] dx = {0, 0, -1, 1};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        MyMap = new int[N][M];
//
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < M; j++) {
//                MyMap[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        for (int y = 0; y < N; y++) {
//            for (int x = 0; x < M; x++) {
//                boolean[][] Visited = new boolean[N][M];
//                DFS(y, x, 1, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), Visited);
//            }
//        }
//
//        System.out.println(Collections.max(totalSumList));
//    }
//
//    private static void DFS(int startY, int startX, int count, List<Integer> sumList, List<int[]> indexList, List<int[]> tempIndexList, boolean[][] visitedMap) {
//        sumList.add(MyMap[startY][startX]);
//        indexList.add(new int[]{startY, startX});
//        visitedMap[startY][startX] = true;
//
//        if (count == 4) {
//            indexList.sort((a, b) -> {
//                if (a[0] != b[0]) {
//                    return Integer.compare(a[0], b[0]);
//                } else {
//                    return Integer.compare(a[1], b[1]);
//                }
//            });
//
//            if (!tempIndexList.contains(indexList)) {
//                tempIndexList.add(new ArrayList<>(indexList));
//                totalSumList.add(sumList.stream().mapToInt(Integer::intValue).sum());
//            }
//            return;
//        }
//
//        for (int dir = 0; dir < 4; dir++) {
//            int nextY = startY + dy[dir];
//            int nextX = startX + dx[dir];
//
//            if (isSafe(nextY, nextX) && !visitedMap[nextY][nextX]) {
//                DFS(nextY, nextX, count + 1, new ArrayList<>(sumList), new ArrayList<>(indexList), tempIndexList, visitedMap);
//            }
//        }
//
//        visitedMap[startY][startX] = false;
//    }
//
//    private static boolean isSafe(int y, int x) {
//        return 0 <= y && y < N && 0 <= x && x < M;
//    }
//}
