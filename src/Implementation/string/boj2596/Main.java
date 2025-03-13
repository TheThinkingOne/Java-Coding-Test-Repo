package Implementation.string.boj2596;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문자와 이진수 매핑
        Map<String, Character> codeMap = new HashMap<>();
        codeMap.put("000000", 'A');
        codeMap.put("001111", 'B');
        codeMap.put("010011", 'C');
        codeMap.put("011100", 'D');
        codeMap.put("100110", 'E');
        codeMap.put("101001", 'F');
        codeMap.put("110101", 'G');
        codeMap.put("111010", 'H');

        // 입력 받기
        int n = scanner.nextInt();
        String encodedMessage = scanner.next();

        StringBuilder decodedMessage = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String segment = encodedMessage.substring(i * 6, (i + 1) * 6); // 숫자 6개씩 잘라서 보기

            if (codeMap.containsKey(segment)) { // 자른 문자열을 키값으로 가지고 있는지 확인
                decodedMessage.append(codeMap.get(segment)); // 알파벳 01숫자 일지할 경우 StringBuilder 에 대입
            } else {
                boolean found = false;
                for (Map.Entry<String, Character> entry : codeMap.entrySet()) {

                    // entrySet() : Map의 모든 키-값 쌍을 Set 형태로 변환

                    String key = entry.getKey(); // 6글자 이진수 문자열
                    int diffCount = 0;
                    for (int j = 0; j < 6; j++) {
                        if (segment.charAt(j) != key.charAt(j)) { // charAt(j) : j번째 인덱스의 문자열 조회
                            diffCount++; // 다르면 ++
                        }
                    }
                    if (diffCount == 1) { // 한개만 다르면
                        decodedMessage.append(entry.getValue()); // 한개만 다르면 해당 알파벳으로 처리 \
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }

        System.out.println(decodedMessage.toString());
    }
}


