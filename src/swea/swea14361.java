package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea14361 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i=1; i<= TC; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String isPossible = check(num);
            System.out.println("#" + i + " " + isPossible);
        }

    }

    // 자릿수가 바뀔때까지 곱해보고 안 되면 impossible 리턴
    private static String check(int num) {
        String originalNumStr = String.valueOf(num); // num을 String 으로 바꿈
        /*char[] originalNumToChar = originalNumStr.toCharArray();*/
        /*int[] originIntArr = new int[originalNumStr.length()];*/
        List<Integer> originIntArr = new ArrayList<>();
        int num_clone = num;

        for (int i = 0; i < originalNumStr.length(); i++) {
            originIntArr.add(Character.getNumericValue(originalNumStr.charAt(i)));
        }
        Collections.sort(originIntArr);

        while (true) {
            num += num_clone;
            String numStr = String.valueOf(num);
            if (numStr.length() > originalNumStr.length()) {
                return "impossible";
            }

            List<Integer> numToChar = new ArrayList<>();
            for (int i = 0; i < originalNumStr.length(); i++) {
                numToChar.add(Character.getNumericValue(numStr.charAt(i)));
            }
            Collections.sort(numToChar);

            if (originIntArr.equals(numToChar)) return "possible";

        }

        /*return "possible";*/
    }
}
