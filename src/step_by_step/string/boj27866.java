package step_by_step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class boj27866 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int i = sc.nextInt();

        char[] charArray = st.toCharArray();

        ArrayList<Character> arrayList = new ArrayList<>();
        for (char ch : charArray) {
            arrayList.add(ch);
        }

        System.out.println(arrayList.get(i-1));

        //System.out.println(arrayList.get(i-1));

    }
}
