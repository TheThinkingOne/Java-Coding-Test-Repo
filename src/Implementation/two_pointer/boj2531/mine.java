package Implementation.two_pointer.boj2531;

//package study0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class mine { // 백준 2516 회전초밥
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int D = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        ArrayList<Integer> food = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        try {
            String input = br.readLine();
            st = new StringTokenizer(input);

            while (st.hasMoreTokens()) {
                food.add(Integer.parseInt(st.nextToken()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.sort(food);

        int minIndex = 0;
        int maxIndex = N-1;

        while (minIndex < maxIndex) {
            if (set.size() == K) {
                break;
            }

            int min = food.get(minIndex);
            int max = food.get(maxIndex);
            set.add(min); set.add(max);

            minIndex++; maxIndex++;

        }

        if ((N % 2 == 1) && set.size() != K)  {
            set.add(food.get(N/2));
        }

        set.add(C);

        System.out.println(set.size());
    }
}
