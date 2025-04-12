package Implementation.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class namkang_highteck_problem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int[] result = new int[word.length()];
        Map<Character, Integer> map = new HashMap<>();
        // key, value

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            System.out.println(map.get(c));
            if (map.containsKey(c)) {
                result[i] = i - map.get(c); // HashMap 의 get 키는 해당 맵의 value 값을 가져오는 함수
            } else {
                result[i] = -1;
            }
            map.put(c, i);
        }

        // map.getOrDefault("orange", -1)  // 키가 없으면 기본값 -1 반환

        System.out.println(Arrays.toString(result));
    }
}
