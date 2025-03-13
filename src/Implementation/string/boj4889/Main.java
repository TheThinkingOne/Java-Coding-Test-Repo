package Implementation.string.boj4889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //문자열에 행할 수 있는 연산은 여는 괄호를 닫는 괄호로 바꾸거나,
        // 닫는 괄호를 여는 괄호로 바꾸는 것 2가지이다.
        String input = "";
        //boolean flag = false;

        while (true) {
            String line = sc.nextLine();
            if (line.contains("-")) break;

            int leftCount = 0;
            int rightCount = 0;

            if (!line.isEmpty() && !line.contains("-")) {
                input += line + "\n";
                char[] inputChars = input.toCharArray();
                char temp = 0;

                for (char ch : inputChars) {
                    if (ch == '{') {
                        temp = '{';
                        leftCount += 1;
                    }

                    else if (ch == '}') {
                        rightCount += 1;
                        if (temp == '{') {
                            leftCount -= 1;
                            rightCount -= 1;
                        }
//                        else if (temp == '}') {
//                            continue;
//                        }
                    }
                }

                System.out.println(Math.max(rightCount,leftCount)-1);


            }
        }



    }
}
