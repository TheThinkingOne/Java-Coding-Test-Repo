package swea.D3.swea1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// swea 1208 flattern
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 1; i <= 10; i++) {

            int dump = Integer.parseInt(br.readLine());
            String boxes = br.readLine();
            List<Integer> boxList = Arrays.stream(boxes.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Collections.sort(boxList);
            Deque<Integer> deque = new ArrayDeque<>(boxList);
            for (int j=0; j<dump; j++) {

                if (deque.getFirst() - deque.getLast() == 1) break;

                int min = deque.pollFirst();
                int max = deque.pollLast();
                max--; min++;
                int nextMin = deque.getFirst();
                int nextMax = deque.getLast();

                if (nextMin < min) {
                    deque.removeFirst();
                    deque.addFirst(min);
                    deque.addFirst(nextMin);
                }

                if (nextMax > max) {
                    deque.removeLast();
                    deque.addLast(max);
                    deque.addLast(nextMax);
                }

            }

            int lastMax = deque.getLast();
            int lastMin = deque.getFirst();

            System.out.println("#" + i + " " + (lastMax-lastMin));
        }
    }
}
