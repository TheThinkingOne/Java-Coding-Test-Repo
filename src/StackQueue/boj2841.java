//package StackQueue;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.LinkedList;
//
//
//public class boj2841 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        Stack<ArrayList<Integer>> stack = new Stack<>();
//        ArrayList<Integer> list = new ArrayList<>();
//
//        int N = Integer.parseInt(st.nextToken());
//        int P = Integer.parseInt(st.nextToken());
//
//        int count = 0;
//
//        for (int i=0; i<N; i++) {
//            st = new StringTokenizer(br.readLine());
//            int line = Integer.parseInt(st.nextToken());
//            int pret = Integer.parseInt(st.nextToken());
//            if (stack.isEmpty()) {
//                list.add(line);
//                list.add(pret);
//                stack.push(list);
//                count += 1;
//            } else {
//                for (int j=0; j< stack.size(); j++) {
//
//                }
//            }
//
//
//        }
//
//    }
//}
