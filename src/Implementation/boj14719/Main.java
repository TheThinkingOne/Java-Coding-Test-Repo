package Implementation.boj14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);

        int H = Integer.parseInt(st.nextToken()); // 높이
        int W = Integer.parseInt(st.nextToken()); // 너비

        //String[] heights = sc.nextLine().split(" ");

        ArrayList<ArrayList<Integer>> MyMap = new ArrayList<>();

        for (int i=0; i<H; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j=0; j<W; j++) {
                row.add(0);
            }
            MyMap.add(row);
        }

        List<Integer> heights = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            heights.add(Integer.parseInt(st.nextToken()));
        }

        //System.out.println(MyMap);

        for (int i = 0; i < W; i++) {
            for (int j = heights.get(i) - 1; j >= 0; j--) {
                MyMap.get(i).set(j, MyMap.get(i).get(j) + 1);
            }
        }

        //System.out.println(heights);



    }
}
