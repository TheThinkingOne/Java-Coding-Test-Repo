package Implementation.boj15686;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M;
    static List<List<Integer>> myMap = new ArrayList<>();
    static List<List<Integer>> allDistanceList = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            List<Integer> info = new ArrayList<>();
            for (String s : input) {
                info.add(Integer.parseInt(s));
            }
            myMap.add(info);
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (myMap.get(y).get(x) == 2 && !visited[y][x]) {
                    int startY = y;
                    int startX = x;
                    visited[y][x] = true;
                    visited = new boolean[N][N];
                    DFS(startY, startX);
                }
            }
        }

        List<List<Integer>> sortedList = new ArrayList<>(allDistanceList);
        sortedList.sort((a, b) -> Integer.compare(sumList(a), sumList(b)));
        sortedList = sortedList.subList(0, M);

        int numLists = sortedList.size();
        int numElements = sortedList.get(0).size();

        int[] minValues = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            minValues[i] = Integer.MAX_VALUE;
        }

        for (List<Integer> distances : sortedList) {
            for (int j = 0; j < numElements; j++) {
                minValues[j] = Math.min(minValues[j], distances.get(j));
            }
        }

        int totalSum = sumArray(minValues);

        System.out.println(totalSum);
    }

    private static void DFS(int startY, int startX) {
        List<Integer> distanceList = new ArrayList<>();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (myMap.get(y).get(x) == 1 && !visited[y][x]) {
                    visited[y][x] = true;
                    int distance = Math.abs(startY - y) + Math.abs(startX - x);
                    distanceList.add(distance);
                }
            }
        }
        allDistanceList.add(distanceList);
    }

    private static int sumList(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }

    private static int sumArray(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}

