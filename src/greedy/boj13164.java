package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj13164 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        // int start = N - K + 1; // 5-3+1 = 3

        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tempList.add(sc.nextInt());
        }

        Set<Integer> set = new HashSet<>(tempList);
        int indexCheck = 0;

        if (set.size() != 1) {
            for (int i = N-1; i > 0; i--) {
                int current = tempList.get(i);
                int next = tempList.get(i-1);
                if (current != next) {
                    indexCheck = i;
                    break;
                }
            }
        }

        List<Integer> firstList = new ArrayList<>();
        int range = indexCheck - K + 2;
        for (int i = 0; i < range; i++) {
            firstList.add(tempList.get(i));
        }

        sc.close();

        int first = firstList.get(0);
        int last = firstList.get(firstList.size()-1);

        int firstDiff = last - first; // 첫번째 리스트에서 뽑는건 알겠는데

        System.out.println(firstList);
        System.out.println(first);
        System.out.println(last);



    }
}
