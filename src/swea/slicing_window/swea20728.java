package swea.slicing_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class swea20728 {

    static int K;
    static List<Integer> list;
    static boolean[] visited;
    static int difference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());

            list = new ArrayList<>();

            int N = Integer.parseInt(st.nextToken()); // 주머니의 개수
            K = Integer.parseInt(st.nextToken()); // 나눠줄 주머니 개수

            list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            visited = new boolean[list.size()];
            difference = Integer.MAX_VALUE;

            if (N==K) {
                getMinAndMax(list);
                System.out.println("#" + (i+1) + " " + difference);
            }

            else {
                combination(0,0, new ArrayList<>());

                System.out.println("#" + (i+1) + " " + difference);
            }

            /*Collections.sort(list);*/

            /*for (int j : list) {

            }*/

        }

    }

    private static void combination(int start, int count, List<Integer> resultList) {
        if (count == K) {
            getMinAndMax(resultList);
            return;
        } /*else {
            for (int i=0; i<list.size(); i++) {
                visited[i] = true;
                combination(list, visited, count+1);
            }
        }*/
        else {
            for (int i = start; i < list.size(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    resultList.add(list.get(i));
                    combination(i + 1, count + 1, resultList);
                    visited[i] = false;
                    resultList.remove(resultList.size()-1); // 마지막 요소 제거
                }
            }
        }
    }

    private static void getMinAndMax(List<Integer> list) {
        int min = Collections.min(list);
        int max = Collections.max(list);

        difference = max - min;
    }
}
