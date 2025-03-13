package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea20019_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();

            StringBuilder firstSB = new StringBuilder(); // 앞부분
            StringBuilder secondSB = new StringBuilder(); // 뒷부분

            for (int j = 0; j < chars.length / 2; j++) {
                firstSB.append(chars[j]);
            }
            // 문자열 길이가 짝수인지 홀수인지 판별
            for (int j = (chars.length % 2 == 0 ? chars.length / 2 : chars.length / 2 + 1); j < chars.length; j++) {
                secondSB.append(chars[j]);
            }

            // 뒷부분 뒤집은것
            String secondSB_back = new StringBuilder(secondSB).reverse().toString();

            // 세 가지 팰린드롬 조건 검사
            if (isWholePalindrome(line) && isWholePalindrome(firstSB.toString()) && isWholePalindrome(secondSB_back)) {
                System.out.println("#" + (i + 1) + " YES");
            } else {
                System.out.println("#" + (i + 1) + " NO");
            }
        }
    }

    // 팰린드롬인지 검사
    private static boolean isWholePalindrome(String input) {
        int len = input.length();
        for (int i = 0; i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
