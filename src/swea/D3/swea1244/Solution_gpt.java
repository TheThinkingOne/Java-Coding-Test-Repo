package swea.D3.swea1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_gpt {
    static int max;
    static int changeCount;
    static Set<String>[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            changeCount = Integer.parseInt(st.nextToken());
            max = 0;

            visited = new HashSet[changeCount + 1]; // visited 를 set 로 설정한 이유?
            for (int i = 0; i <= changeCount; i++) {
                visited[i] = new HashSet<>();
            }

            //System.out.println(Arrays.toString(visited));

            dfs(num.toCharArray(), 0);
            System.out.println("#" + t + " " + max);
        }
    }

    static void dfs(char[] arr, int depth) { // depth 는 0부터 시작
        if (depth == changeCount) { // 마지막 교환이라면
            max = Math.max(max, Integer.parseInt(new String(arr))); // 초기 값이랑 더 큰 값이랑 더 큰거 반환
            return;
        }

        String current = new String(arr);
        if (visited[depth].contains(current)) return; // 이미 나온거면 안함
        visited[depth].add(current); // 처음 나온 교환숫자면 저장

        int len = arr.length; // [7,5,7,1,4,8] => 6
        for (int i = 0; i < len - 1; i++) { // i = 0~4
            for (int j = i + 1; j < len; j++) { // j = 1~5
                swap(arr, i, j);
                dfs(arr, depth + 1);
                swap(arr, i, j); // 백트래킹(복구) => [7,5,7,1,4,8] => [5,7,7,1,4,8] => [7,5,7,1,4,8]
            }
        }

    }

    static void swap(char[] arr, int i, int j) { // i=0, j=1 이고 arr = [7,5,7,1,4,8] 인 경우
        char temp = arr[i]; // temp = arr[0] = 7
        arr[i] = arr[j]; // arr[0] = arr[1] => arr[0] = 5
        arr[j] = temp; // arr[1] = 7
        // => [5,7,7,1,4,8] 되는건가
    }
}

