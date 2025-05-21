package swea.D3.swea22574;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int TC = Integer.parseInt(br.readLine());
        int maxFloor = 1000000000;
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 기회 수
            int P = Integer.parseInt(st.nextToken()); // 폭탄 있는 층
            int count = 0;
            int floorSum = 0;
            // N <= 2000, P <= 4000000
            int maxSum = 0;
            if (N%2==0) {
                maxSum = (N+1)*(N/2);
            } else {
                maxSum = ((N-1)+1)*((N-1)/2) + N;
            }

            if (maxSum < P) floorSum = maxSum;
            else {
                while (count < N) {
                    int move = count + 1; // i번째 선택에서 i만큼 이동 가능
                    int next = floorSum + move;

                    // P층이면 가만히 있는 선택
                    if (next == P) {
                        count++; // 선택은 했지만 가만히 있었음
                        continue;
                    }

                    // 아니면 올라감
                    floorSum = next;
                    count++;
                }

            }

            System.out.println(floorSum);
        }
    }
}
