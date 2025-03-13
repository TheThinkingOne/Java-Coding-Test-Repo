package Implementation.boj9011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int S;
    static List<Integer> nums;
    static List<Integer> list;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());*/
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        /*for (int i = 0; i < T; i++) {

            int S = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            List<Integer> result = new ArrayList<>();

            for (int j = 0; j < S; j++) {
                int R = sc.nextInt();
                int count = 0;

                if (list.isEmpty()) {
                    list.add(R);
                    result.add(0);
                } else {
                    for (int k = 0; k < list.size(); k++) {
                        if (list.get(k) < R) {
                            count += 1;
                        }
                    }
                    list.add(R);
                    result.add(count);
                }
            }

            int total = 0;
            for (int j = 0; j < result.size(); j++) {
                total += result.get(j);
            }
            if (total == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (int k : result) {
                    System.out.print(k + " ");
                }
            }

        }*/
        for (int i = 0; i < T; i++) {
            S = sc.nextInt();
            list = new ArrayList<>(); // (1부터 S 까지 담는 리스트)

            for (int j=1; j<=S; j++) {
                list.add(j);
            }

            nums = new ArrayList<>(); // 비교대상인 리스트 nums
            // nums = [0,0,0,2,0,1,6,7,6,9]
            set = new HashSet<>();

            for (int j = 1; j <= S; j++) {
                int num = sc.nextInt();
                nums.add(num);
            }

            // nums = [0,0,0,2,0,1,6,7,6,9]
            // list = [1,2,3,4,5,6,7,8,9,10]
            for (int j : list) {
                int count = 0;

                for (int k : nums) {
                    if (nums.get(k) < j) {
                        count += 1;
                    }
                    set.add(count);
                }

                if (set.size() != S) {
                    nums.remove(j);
                }
            }

            if (set.size() != S) {
                System.out.println("IMPOSSIBLE");
            }

        }

    }

    /*private static void checkNums(int j, List<Integer> nums, Set<Integer> set, List<Integer> list) {
        int count = 0;
        //int temp = 0;
        for (int i : nums) {
            if (nums.get(i) < j) {
                count += 1;
            }
        }

        set.add(count);


    }*/


}
