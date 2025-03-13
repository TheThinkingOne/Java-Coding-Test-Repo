package Implementation.string.boj1213;

import java.util.*;

public class GPTver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] charArray = str.toCharArray();
        Map<Character, Integer> charCount = new HashMap<>();

        // 각 문자의 등장 횟수를 센다.
        for (char c : charArray) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 홀수 번 등장하는 문자의 개수를 센다.
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // 홀수 번 등장하는 문자가 2개 이상이면 팰린드롬을 만들 수 없다.
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 팰린드롬을 만든다.
        StringBuilder palindrome = new StringBuilder();
        char oddChar = '\0'; // 홀수 번 등장하는 문자가 없을 경우를 위한 기본값 설정
        for (char c = 'A'; c <= 'Z'; c++) {
            if (charCount.containsKey(c)) {
                int count = charCount.get(c);
                if (count % 2 == 1) { // 홀수 번 등장하는 문자일 경우
                    oddChar = c; // 홀수 번 등장하는 문자 저장
                }
                // 등장 횟수의 반만큼 문자를 추가한다.
                for (int i = 0; i < count / 2; i++) {
                    palindrome.append(c);
                }
            }
        }

        // 팰린드롬을 완성시킨다.
        StringBuilder result = new StringBuilder(palindrome);
        if (oddChar != '\0') {
            result.append(oddChar); // 홀수 번 등장하는 문자를 중간에 추가
        }
        result.append(palindrome.reverse()); // 팰린드롬의 앞부분을 뒤집어서 추가

        System.out.println(result);
    }
}

