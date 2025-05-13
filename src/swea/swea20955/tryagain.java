package swea.swea20955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class tryagain {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {

            String Start = br.readLine(); // 시작스트링
            String End = br.readLine(); // 되고자하는거

            Set<String> checked = new HashSet<>();
            Queue<String> queue = new LinkedList<>();
            queue.add(Start);
            checked.add(Start);

            boolean found = false;

            while (!queue.isEmpty()) {
                String current = queue.poll();
                if (current.equals(End)) {
                    found = true;
                    break;
                }

                if (current.length() >= End.length()) continue;

                // 1번째, 뒤에 X 붙이기
                String addX = current + "X";
                if(!checked.contains(addX)) {
                    checked.add(addX);
                    queue.offer(addX);
                };

                // 2번째, 뒤집고 뒤에 Y 붙이기
                String reverseAndAddY = new StringBuilder(current).reverse().append("Y").toString();
                if(!checked.contains(reverseAndAddY)) {
                    checked.add(reverseAndAddY);
                    queue.offer(reverseAndAddY);
                };

            }

            System.out.println(found ? "Yes" : "No");

        }
    }
}
