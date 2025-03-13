package swea.swea22574;

import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
*/
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for (int i = 1; i <= TC; i++) {
            long N = sc.nextInt();
            long P = sc.nextInt();
            long sum = 0;

            for (int j = 1; j <= N; j++) {
                sum += j;
                if(sum == P) {
                    sum -= i;
                }
            }

            System.out.println(sum);
        }
    }
}
