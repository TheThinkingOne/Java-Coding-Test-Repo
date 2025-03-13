package Implementation.two_pointer.boj11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
        int M = Integer.parseInt(st.nextToken()); // 배열 B의 크기

        ArrayList<Integer> List = new ArrayList<>();
        //ArrayList<Integer> B = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            List.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            List.add(Integer.parseInt(st.nextToken()));
        }

        br.close();

        int start = 0;
        int end = List.size() - 1;
        Collections.sort(List);

        int min = List.get(0);
        int max = List.get(List.size()-1);


        /*while (start < end) {
            int smallTemp = 0;
            int bigTemp = 0;

            int first = List.get(start);
            int second = List.get(end);
            if (first >= second) {

            }
            else {
                smallTemp = first;
            }
        }*/





    }
}
