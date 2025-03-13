package swea.swea10912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<=TC; i++) {
            String str = br.readLine();
            char[] ch = str.toCharArray();
            List<Character> listForSort = new ArrayList<>();
            for(char c : ch) {
                listForSort.add(c);
            }
            Collections.sort(listForSort);

            Queue<Character> queue = new LinkedList<>(listForSort); // 이런식으로 리스트를 큐로 한번에 변환시킬 수 있다

            String result = "";
            int count = 0;
            Arrays.sort(queue.toArray());

            while (queue.size() > 1) {

                int temp = queue.size(); // 큐의 사이즈 (문자열의 길이)
                char current = queue.poll(); // 맨앞에꺼 제거
                char next = queue.peek(); // 제거 안하고 반환만

                if (current == next) {
                    queue.poll();
                    temp = queue.size();
                    count = 0;
                }
                else {
                    queue.add(current);
                    count++;
                    if (count == temp) { // count 가 큐의 사이즈 만큼 된다면 이는 제거되지 않는 무한반복 이므로

                        break;
                    }
                }
            }

            if (queue.isEmpty()) {
                result = "Good";
            }

            else {

                List<Character> tempList = new LinkedList<>(queue);
                Collections.sort(tempList);

                StringBuilder sb = new StringBuilder();
                for (char c : tempList) {
                    sb.append(c);
                }
                result = sb.toString();
            }

            System.out.println("#" + i + " " + result);

        }
    }


}
