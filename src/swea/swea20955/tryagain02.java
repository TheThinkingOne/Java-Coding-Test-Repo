package swea.swea20955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class tryagain02 {

    static boolean found;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            String start = br.readLine(); // 시작 문자열 S
            String end = br.readLine();   // 목표 문자열 E

            found = false;
            backDFS(end, start); //

            System.out.println(found ? "#" + i + " Yes" : "#" + i + " No");
        }
    }

    private static void backDFS(String currentStr, String targetStr) {
        if (found) return;

        if (currentStr.length() < targetStr.length()) return;

        if (currentStr.equals(targetStr)) {
            found = true;
            return;
        }

        // 원래는
        // // S 제일 뒤에 X를 붙임
        //        // S 를 뒤집은 다음 제일 뒤에 Y 붙임`
        // 뒤에 X 더하기 혹은 뒤집고 Y 더하기 인데 이걸 반대로
        if (currentStr.endsWith("X")) {
            backDFS(currentStr.substring(0, currentStr.length() - 1), targetStr);

            // 1. XYYX.substring(0, currentStr.len() - 1) => XYYX.substring(0, 3) => XYY
            // 3. YX.substr(0,1) => Y => correct

        }

        // hamburger.substring(4,8) = urge
        if (currentStr.endsWith("Y")) {
            StringBuilder sb = new StringBuilder(currentStr.substring(0, currentStr.length() - 1));
            backDFS(sb.reverse().toString(), targetStr);

            // 2. XYY.substring(0, currentStr.len() -1) => XYY.substring(0,2) => XY => XY.reverse() => YX

        }
    }
}
