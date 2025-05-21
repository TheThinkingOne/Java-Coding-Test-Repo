package swea.D3.swea22979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 S에 다음과 같은 연산을 몇 번 적용할 것이다.
        //
        //각각의 연산은 정수 X로 표현되며, X에 따라 문자열 S가 아래와 같이 변한다.

        //· X > 0이면, S의 첫 번째 글자를 떼네어 마지막 글자 뒤에 붙이는 작업을 정확히 X회 반복한다.
        //· X < 0이면, S의 마지막 글자를 떼네어 첫 번째 글자 앞에 붙이는 작업을 정확히 -X회 반복한다.
        //· X = 0이면, 아무 일도 일어나지 않는다.

        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {

            String line = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String numLine = br.readLine();

            Deque<String> deque = new LinkedList<>();
            for (char c : line.toCharArray()) {
                deque.addLast(String.valueOf(c));
            }

            List<Integer> numList = Arrays.stream(numLine.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            for (int j = 0; j < count; j++) {

                int performance = numList.get(j);
                if (performance > 0) plus(deque, performance);
                else if (performance < 0) minus(deque, -performance);
                else continue;
            }

            List<String> dequeList = deque.stream().collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            for (String s : dequeList) {
                sb.append(s);
            }

            // 또는 아래처럼
            // for (int j = 0; j < size; j++) {
            //    sb.append(deque.poll());
            //}

            System.out.println(sb);

        }

    }

    // performance 가 존나 큰 숫자 들어오면
    private static void plus(Deque<String> deque, int performance) {
        int rotate = performance % deque.size();
        for (int i = 0; i < rotate; i++) {
            deque.addLast(deque.poll());
        }
    }

    private static void minus(Deque<String> deque, int performance) {
        int rotate = performance % deque.size();
        for (int i = 0; i < rotate; i++) {
            deque.addFirst(deque.pollLast());
        }
    }
}
