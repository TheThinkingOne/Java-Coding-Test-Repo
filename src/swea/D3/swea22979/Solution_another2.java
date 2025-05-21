package swea.D3.swea22979;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_another2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            String line = br.readLine();
            int count = Integer.parseInt(br.readLine());
            String[] ops = br.readLine().split(" ");

            Deque<Character> deque = new LinkedList<>();
            for (char c : line.toCharArray()) deque.addLast(c);

            for (String op : ops) {
                int rotate = Integer.parseInt(op);
                int len = deque.size();
                int shift = Math.abs(rotate) % len;

                if (rotate > 0) {
                    for (int i = 0; i < shift; i++) deque.addLast(deque.pollFirst());
                } else if (rotate < 0) {
                    for (int i = 0; i < shift; i++) deque.addFirst(deque.pollLast());
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : deque) sb.append(c);
            System.out.println(sb);
        }
    }
}

