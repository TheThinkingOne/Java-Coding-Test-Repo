package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea20019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();

            StringBuilder firstSB = new StringBuilder(); // 앞 글자
            StringBuilder secondSB = new StringBuilder(); // 뒷 글자
            // 뒷글자 뒤집은거

            for (int j = 0; j < chars.length/2; j++) {
                firstSB.append(chars[j]);
            }
            for (int j = chars.length/2+1; j < chars.length; j++) {
                secondSB.append(chars[j]);
            }

            String secondSB_back = new StringBuilder(secondSB).reverse().toString();

            // 확인용
            /*System.out.println("Original secondSB: " + secondSB);
            System.out.println("Reversed secondSB_back: " + secondSB_back);*/


            if (isWholePalendrome(String.valueOf(firstSB), secondSB_back) && isFirstPalendrome(String.valueOf(firstSB)) && isLastPalendrome(String.valueOf(secondSB))) {
                System.out.println("#" + (i+1) +  " YES");
            } else {
                System.out.println("#" + (i+1) +  " NO");
            }

        }
    }

    private static boolean isWholePalendrome(String firstSB, String secondSB_back) {
        if (firstSB.equals(secondSB_back)) return true;
        else return false;
    }

    private static boolean isFirstPalendrome(String firstSB) {
        char[] chars = firstSB.toCharArray();
        StringBuilder front = new StringBuilder();
        for (int i = 0; i < chars.length/2; i++) {
            front.append(chars[i]);
        }
        String back = new StringBuilder(front).reverse().toString();

        if (front.toString().equals(back)) return true;
        else return false;
    }

    private static boolean isLastPalendrome(String secondSB) {
        char[] chars = secondSB.toCharArray();
        StringBuilder front = new StringBuilder();
        for (int i = 0; i < chars.length/2; i++) {
            front.append(chars[i]);
        }
        String back = new StringBuilder(front).reverse().toString();

        if (front.toString().equals(back)) return true;
        else return false;
    }

}
