package Implementation.boj16967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            StringBuilder result = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // N=10
            int M = Integer.parseInt(st.nextToken()); // M=12

            String[] group1 = br.readLine().split(" ");
            String[] group2 = br.readLine().split(" ");

            int Samlamansang = findLCM(N, M); //최소공배수 찾기 => 60
            int num1 = Samlamansang / group1.length; // num1 = 6
            int num2 = Samlamansang / group2.length; // num2 = 5

            String[] extendedGroup1 = extendArray(group1, num1); //첫번째 입력문자들
            String[] extendedGroup2 = extendArray(group2, num2); //두번째

            int Q = Integer.parseInt(br.readLine()); // 출생일의 개수
            for (int j = 0; j < Q; j++) {
                int birthYear = Integer.parseInt(br.readLine()); // 출생일
                int namingYear = birthYear % Samlamansang; // 육십갑자 이름을 계산하기 위한
                result.append(extendedGroup1[namingYear - 1]).append(extendedGroup2[namingYear - 1]).append(" ");
            }

            System.out.println("#" + (i + 1) + " " + result.toString());
        }
    }

    private static int findGCD(int num1, int num2) { //최대공약수 구하는 함수
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    private static int findLCM(int num1, int num2) { //최소공배수 구하는 함수
        return (num1 * num2) / findGCD(num1, num2);
    }

    private static String[] extendArray(String[] array, int num) { //각각의 배열을 연장하는 함수
        String[] extendedArray = new String[num * array.length];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < array.length; j++) {
                extendedArray[i * array.length + j] = array[j];
            }
        }
        return extendedArray;
    }
}
