package Implementation.string.boj4889;

import java.util.ArrayList;
import java.util.Scanner;

public class StackVer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = 1;
        while (true) {
            String line = sc.nextLine();
            if (line.contains("-")) break; // 종료 조건

            int changeCount = 0; // 변경 횟수
            int balance = 0; // 괄호의 균형을 맞추기 위한 변수

            char[] charArray = line.toCharArray();
            ArrayList<Character> stack = new ArrayList<>();
            for (int i=0; i<charArray.length; i++) {
                if (charArray[i] == '{') {
                    stack.add('{');
                }
                else if (charArray[i] == '}') {
                    if (!stack.isEmpty()) {
                        stack.remove(stack.size()-1);
                    } else {
                        changeCount += 1;
                    }
                }
            }

            changeCount += stack.size();
            System.out.println(TC + ". " + changeCount);
            TC ++;
        }
        sc.close();
    }
}
