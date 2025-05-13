package swea.swea20955;

import java.io.*;
import java.util.*;

public class swea20955_gpt {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            String start = br.readLine();
            String goal = br.readLine();

            Set<String> visited = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.offer(start);
            visited.add(start);

            boolean found = false;

            while (!queue.isEmpty()) {
                String current = queue.poll();

                if (current.equals(goal)) {
                    found = true;
                    break;
                }

                if (current.length() >= goal.length()) continue;

                // 연산 1: 뒤에 'X' 추가
                String op1 = current + "X";
                if (!visited.contains(op1)) {
                    visited.add(op1);
                    queue.offer(op1);
                }

                // 연산 2: 뒤집고 뒤에 'Y' 추가
                String op2 = new StringBuilder(current).reverse().append("Y").toString();
                if (!visited.contains(op2)) {
                    visited.add(op2);
                    queue.offer(op2);
                }
            }

            System.out.println(found ? "Yes" : "No");
        }
    }
}

