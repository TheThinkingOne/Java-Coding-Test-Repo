package swea.swea22759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            st = new StringTokenizer(br.readLine());
            // L개 이상 R개 이하의 음료수를 구매
            // N mod X가 X/2 이상이면 고객이 단제품 N mod X개 대신
            // 음료수 X개 짜리 묶음 세트를 하나 더 구매할 것이라고 생각
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            boolean correct = false;

            // N mod X 했을 떄의 값이 X/2 이상이면 차라리 묶음을 살 것임
            // L = 100, R = 150 이면
            // X가 170이면 =>
            // X의 범위 어떻게 설정?
            // 100개 사려는 사람이 101개짜리 묶음
//            for (int j = L; j <= R; j++) {
//                // int half = j / 2;
//                // int share = j/170;
//                // j/2 가 j mod X ( j를 X로 나눈 나머지) 이상이면 걍 묶음 하나 더 살것
//                // int remainder = j%170;
//            }

//            System.out.println(list);ㅜㅕㅗㅠ

            if (R+1 <= 2*L) {
                correct = true;
            }

            System.out.println(correct ? "yes" : "no");

        }

    }
}
