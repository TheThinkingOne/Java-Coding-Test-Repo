package Implementation.string.boj20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GptVer {
    public static void main(String[] args) throws IOException {
        // 자주 나오는 단어일수록 앞에 배치
        // 길이가 길수록 앞에 배치
        // 알파벳 사전순
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();
        // 키(String)는 단어, Integer 는 단어의 빈도수

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                // getOrDefault : 주어진 키가 맵에 존재하면 해당 키의 값을 반환, 아니라면 기본값 반환
                // 단어가 처음 등장하면 빈도수가 1이 되고, 이미 존재하면 현재 빈도수에 1++
            }
        }

        // System.out.println(wordMap);
        // {mouse=2, appearance=1, wallet=1, append=1, attendance=1, swift=3}

        List<String> wordList = new ArrayList<>(wordMap.keySet());

        // System.out.println(wordList);
        // [mouse, appearance, wallet, append, attendance, swift]

        wordList.sort((word1, word2) -> {
            // Comparator
            int count1 = wordMap.get(word1); // Map 에서 value 값 뽑아오기(빈도수)
            int count2 = wordMap.get(word2); // Map 에서 value 값 뽑아오기(빈도수)

            // ex) Mouse = 2, appearance = 1

            if (count1 != count2) {
                return count2 - count1; // 빈도수가 높은순으로 정렬
            }
            else if (word1.length() != word2.length()) {
                return word2.length() - word1.length(); // 길이가 긴 단어가 앞으로
            }
            else {
                return word1.compareTo(word2); // 알파벳 사전순 정렬
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);

    }
}

