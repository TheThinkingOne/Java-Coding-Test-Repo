package Implementation.boj20055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> MyMap = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<2*N; i++) {

            int num = Integer.parseInt(st.nextToken());
            MyMap.add(num);
        }

        int count = 0;
        int zeroCount = 0;
        // System.out.println(MyMap.get(0));
        //MyMap[0] = start, MyMa[N-1] = outpoint
        MyMap.set(0, MyMap.get(0) - 1);
//        while (true) {
//            if (MyMap.get(0) != 0) {
//                MyMap.set(0, MyMap.get(0) - 1);
//            }
//            if (MyMap.get(1) > 0) {
//                int temp = MyMap.remove(0);
//                MyMap.add(temp);
//                count += 1;
//            } else {
//                int temp = MyMap.remove(0);
//                MyMap.add(temp);
//            }
//            for (int num : MyMap) {
//                if (num == 0) {
//                    zeroCount += 1;
//                }
//            }
//            if (zeroCount == K) {
//                System.out.println(count);
//                break;
//            }
//        }
        while (true) {
            if (MyMap.get(0) != 0) {
                MyMap.set(0, MyMap.get(0) - 1);
            }
            if (MyMap.get(1) > 0) {
                int temp = MyMap.remove(0);
                MyMap.add(temp);
                count += 1;
            } else {
                int temp = MyMap.remove(0);
                MyMap.add(temp);
            }
            for (int num : MyMap) {
                if (num == 0) {
                    zeroCount += 1;
                }
            }
            if (zeroCount == K) {
                System.out.println(count);
                break;
            }
        }




    }
}
