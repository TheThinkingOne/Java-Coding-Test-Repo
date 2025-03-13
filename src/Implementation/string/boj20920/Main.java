package Implementation.string.boj20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 자주 나오는 단어일수록 앞에 배치
        // 길이가 길수록 앞에 배치
        // 알파벳 사전순
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> wordSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            String word = br.readLine();
            char[] charArray = word.toCharArray();

            if (charArray.length >= M) {
                for (char j : charArray) {
                    sb.append(j);
                }
                wordSet.add(sb.toString());
            }

        }

        List<String> resultSet = new ArrayList<>(wordSet);
        // 길이가 더 짧은걸 어떻게 구분?

        Collections.sort(resultSet);

        for (String i : resultSet) {
            System.out.println(i);
        }



    }
}
