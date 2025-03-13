package step_by_step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String st = br.readLine();
            char[] charArray = st.toCharArray();
            int length = charArray.length;
            System.out.print(charArray[0]);
            System.out.print(charArray[length-1]);
//            System.out.print(charArray[0]);
//            System.out.print(charArray[-1]);
//            System.out.println();
            System.out.println();
        }
    }
}
