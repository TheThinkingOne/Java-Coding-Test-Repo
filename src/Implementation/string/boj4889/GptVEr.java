package Implementation.string.boj4889;

import java.util.Scanner;

public class GptVEr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = 1;
        while (true) {
            String line = sc.nextLine();
            if (line.contains("-")) break;

            int changeCount = 0; // 변경횟수
            int balance = 0; // 괄호의 균형 맞추기 위한 변수

            for (char ch : line.toCharArray()) {
                if (ch == '{') {
                    balance += 1; //
                } else if (ch == '}') {
                    if (balance == 0) { // 닫는 괄호가 더 많은 경우
                         changeCount += 1; // 변경(횟수 증가)
                         balance += 1; // 여는 괄호로 변경해 균형 맞추기
                    } else { // 여는 괄호가 더 많은 경우
                        balance -= 1;
                    }
                }
            }
            changeCount += balance / 2;
            // ex) 여는 괄호 4개 있는 경우 4 / 2 => 2번 변경 후 changeCount 에 더함

            System.out.println(TC + ". " + changeCount);
            TC ++;
        }
        sc.close();
    }
}
