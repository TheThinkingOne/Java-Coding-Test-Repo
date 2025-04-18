package StackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            else {
                if (order.equals("top")) {

                    if(!stack.isEmpty()) System.out.println(stack.peek());
                    else System.out.println(-1);

                } else if (order.equals("size")) {
                    System.out.println(stack.size());

                } else if (order.equals("empty")) {

                    if (stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);

                } else if (order.equals("pop")) {
                    if (!stack.isEmpty()) System.out.println(stack.pop());
                    else System.out.println(-1);
                }
            }
        }


    }
}
