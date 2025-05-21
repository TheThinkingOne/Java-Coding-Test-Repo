package swea.D3.swea24001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
//    static int timer;
//    static int point;
    static int size;
    static char[] chars;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 0; i < TC; i++) {
            chars = br.readLine().toCharArray();
            result = new ArrayList<>();
            int point = 0;
            int timer = 0;
            int end = 0;
            size = chars.length;
            for (char c : chars) {
                if (c == 'L') {
                    goLeft(point, timer);
                }
                else if (c == 'R') {
                    goRight(point, timer);
                }
                else {
                    goLeft(point, timer);
                    goRight(point, timer);
                }
            }

            Collections.sort(result);
            int min = Math.abs(result.get(0));
            int max = result.get(result.size() - 1);
            if (min <= max) end = max;
            else if (min > max) end = min;
            System.out.println(end);
        }
    }

    private static void goRight(int point, int timer) {
        point++; timer++;
        if (timer == size) {
            result.add(point);
            return;
        }
        char next = chars[timer];
        if (next == 'R') {
            goRight(point, timer);
        }
        else if (next == 'L') {
            goLeft(point, timer);
        }
        else if (next == '?') {
            goLeft(point, timer);
            goRight(point, timer);
        }
    }

    private static void goLeft(int point, int timer) {
        point--; timer++;
        if (timer == size) {
            result.add(point);
            return;
        }
        char next = chars[timer];
        if (next == 'R') {
            goRight(point, timer);
        }
        else if (next == 'L') {
            goLeft(point, timer);
        }
        else if (next == '?') {
            goLeft(point, timer);
            goRight(point, timer);
        }
    }

}
