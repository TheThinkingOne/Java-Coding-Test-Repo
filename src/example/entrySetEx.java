package example;
import java.util.*;

public class entrySetEx {
    public static void main(String[] args) {
        // Map 생성
        Map<String, Character> map = new HashMap<>();
        map.put("000000", 'A');
        map.put("001111", 'B');
        map.put("010011", 'C');

        // entrySet()을 통해 Map의 키-값 쌍에 접근
        for (Map.Entry<String, Character> entry : map.entrySet()) {
            // 키와 값 출력
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
    }
}
