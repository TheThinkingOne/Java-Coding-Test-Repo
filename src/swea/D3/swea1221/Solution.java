package swea.D3.swea1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 1; i <= TC; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String questionNum = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            Map<String, Integer> countMap = new LinkedHashMap<>();
            // 그냥 HaspMap 말고 LinkedHashMap 써야 넣은 순서대로 보장됨
            String[] keys = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
            for (String key : keys) {
                countMap.put(key, 0); // 초기화
            }

            String[] words = br.readLine().split(" ");
            for (String word : words) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1); // 이러캐 해서 맵 안에 단어 갯수(value 값) 갱신
            }

            //System.out.println(countMap);

            System.out.println(questionNum);
            for (String s : countMap.keySet()) {
                int wordCount = countMap.get(s);
                if (wordCount != 0) {
                    for (int j = 0; j < wordCount; j++) {
                        System.out.print(s + " ");
                    }
                }
            }
            System.out.println();

        }
    }
}
