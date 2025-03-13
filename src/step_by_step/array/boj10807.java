package step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> numberList = new ArrayList<>();

        int count = 0;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int number = Integer.parseInt(st.nextToken());
            numberList.add(number);
        }

        int compareNum = Integer.parseInt(br.readLine());

        for (int j=0; j<N; j++) {
            if (numberList.get(j) == compareNum) {
                count += 1;
            }
        }

        System.out.print(count);

    }
}
