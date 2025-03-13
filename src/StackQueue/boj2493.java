package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] towers = new int[N];
        for (int i = 0; i < N; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        stack.push(0);

        for (int i = 1; i < N; i++) {
            int count = 0;
            int k = i - 1;

            while (k >= 0) {
                if (towers[i] < towers[k]) {
                    count = k + 1;
                    stack.push(count);
                    break;
                }
                k--;
            }
            if (k < 0) {
                stack.push(0);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}

