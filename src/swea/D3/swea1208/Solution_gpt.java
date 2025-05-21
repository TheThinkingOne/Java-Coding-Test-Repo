package swea.D3.swea1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution_gpt {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {

            int dump = Integer.parseInt(br.readLine());
            String boxes = br.readLine();

            List<Integer> boxList = Arrays.stream(boxes.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            // 일단 초기 정렬 상태로 deque 생성
            Collections.sort(boxList);
            Deque<Integer> deque = new ArrayDeque<>(boxList);

            for (int i = 0; i < dump; i++) {

                int min = deque.pollFirst(); // 최솟값 꺼냄
                int max = deque.pollLast();  // 최댓값 꺼냄

                // 평탄화 완료 조건
                if (max - min <= 1) {
                    deque.addFirst(min);
                    deque.addLast(max);
                    break;
                }

                min += 1;
                max -= 1;

                // 정렬된 위치에 삽입하기 위해 임시 리스트로 변환
                List<Integer> temp = new ArrayList<>(deque);
                temp.add(min);
                temp.add(max);
                Collections.sort(temp);

                // 다시 deque 초기화
                deque = new ArrayDeque<>(temp);
            }

            int result = deque.peekLast() - deque.peekFirst();
            System.out.println("#" + t + " " + result);
        }
    }
}
