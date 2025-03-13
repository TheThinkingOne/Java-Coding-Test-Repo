package Implementation.boj1074;

import java.util.*;
import java.io.*;

public class Main { // 백준 1074 희로님 버전
    static int n, r, c;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, n); // 한 변의 사이즈

        visit(0, 0, size);

        System.out.println(count);
    }

    public static void visit(int startX, int startY, int size) {
        if(size == 1) {
            return;
        }

        if(r < startX + size / 2 && c < startY + size / 2) {
            visit(startX, startY, size / 2);
        } else if(r < startX + size / 2 && c >= startY + size / 2) {
            count += (size * size) / 4;
            visit(startX, startY + size / 2, size / 2);
        } else if(r >= startX + size / 2 && c < startY + size / 2) {
            count += ((size * size) / 4) * 2;
            visit(startX + size / 2, startY, size / 2);
        } else {
            count += ((size * size) / 4) * 3;
            visit(startX + size / 2, startY + size / 2, size / 2);
        }

    }
}