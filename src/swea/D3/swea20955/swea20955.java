package swea.D3.swea20955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class swea20955 {

    static String goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        // S 제일 뒤에 X를 붙임
        // S 를 뒤집은 다음 제일 뒤에 Y 붙임

        // S,Y => X 혹은 Y 로 이루어진 문자열
        // XYXX 일때 1번 연산 -> XYXXX
        // XYXX 일때 2번 연산 -> XXYX + Y => XXYXY
        int TC = Integer.parseInt(br.readLine());
        // 첫번째 줄은 S, 두번째 줄은 E
        // S를 E로 만들 수 있으면 Yes, 아니면 No 출력
        // DP 문제인듯
        for (int i = 0; i < TC; i++) {

            String S = br.readLine(); // 시작 스트링
            String E = br.readLine(); // 목표
            goal = E;

            String addX = new StringBuilder(S).append("X").toString();
            String revAndAddY = new StringBuilder(E).reverse().append("Y").toString();

            int moreLonger = E.length();
            Set<String> set = new HashSet<>();
            // 더 긴 E를 기준으로
//            String[][] dp = new String[moreLonger][moreLonger];
//            // 초기값 어캐 해야하지
//            dp[0][0] = S;
//            for (int j = 0; j < moreLonger; j++) {
//
//                if (j==0) {
//                    dp[0][j] = addX;
//                }
//                dp[j][0] = addX;
//                dp[j][1] = revAndAddY;
//
//                if (dp[moreLonger-1][j].equals("X")) {})
//            }
            set.add(addX); set.add(revAndAddY);

        }

    }


}
