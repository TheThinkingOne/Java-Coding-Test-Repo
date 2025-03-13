package step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        while (true) {
            String line = br.readLine();

            if (line == null || line.isEmpty()) {
                break;
            }

            StringTokenizer st = new StringTokenizer(line);

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                arrayList1.add(num);
            }

        }

        for (int i=1; i<=30; i++) {
            arrayList2.add(i);
        }

        for (int num : arrayList1) {
            arrayList2.remove(Integer.valueOf(num));
        }

        // 남은 숫자 출력
        for (int num : arrayList2) {
            System.out.println(num);
        }



        //System.out.println(arrayList);


    }
}
