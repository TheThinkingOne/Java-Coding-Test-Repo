package Implementation.string.boj1541;

import java.util.Scanner;

public class GoogleVer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] charArray = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean inBracket = false; // 현재 괄호 안에 있는지 여부를 나타내는 플래그

        for (int i = 0; i < charArray.length; i++) {
            char currentChar = charArray[i];

            if (currentChar == '-') {
                if (!inBracket) { // 이전에 괄호 안에 있지 않았다면
                    sb.append('(');
                    inBracket = true;
                }
                sb.append(currentChar);
                sb.append('(');
            } else if (currentChar == '+') {
                sb.append(currentChar);
                if (inBracket) { // 이전에 괄호 안에 있었다면
                    sb.append(')');
                    inBracket = false;
                }
            } else {
                sb.append(currentChar);
                if (i == charArray.length - 1 && inBracket) { // 마지막이면서 괄호 안에 있었다면
                    sb.append(')');
                    inBracket = false;
                }
            }
        }

        System.out.println(sb.toString());
    }
}

