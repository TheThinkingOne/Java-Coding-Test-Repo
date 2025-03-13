package Implementation.boj16967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringBuilder result = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] group1 = br.readLine().split(" ");
            String[] group2 = br.readLine().split(" ");

            int Samlamansang = findLCM(N, M); //최소공배수 찾기
            int num1 = Samlamansang / group1.length;
            int num2 = Samlamansang / group2.length;

            String[] extendedGroup1 = new String[num1 * group1.length]; //첫번째 입력문자들
            String[] extendedGroup2 = new String[num2 * group2.length]; //두번째

            for (int k = 0; k < num1; k++) {
                System.arraycopy(group1, 0, extendedGroup1, k * group1.length, group1.length);
            } //group1 배열을 여러번 복사해서 새 배열 extendedGroup1에 넣음

            for (int k = 0; k < num2; k++) {
                System.arraycopy(group2, 0, extendedGroup2, k * group2.length, group2.length);
            }

            int Q = Integer.parseInt(br.readLine());
            for (int j = 0; j < Q; j++) {
                int birthYear = Integer.parseInt(br.readLine());
                int namingYear = birthYear % Samlamansang;
                result.append(extendedGroup1[namingYear - 1]).append(extendedGroup2[namingYear - 1]).append(" ");
            }

            System.out.println("#" + (i + 1) + " " + result.toString());
        }
    }

    private static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    private static int findLCM(int num1, int num2) {
        return (num1 * num2) / findGCD(num1, num2);
    }
}

