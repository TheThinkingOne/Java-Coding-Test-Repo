package step_by_step;

import java.io.*;
import java.util.StringTokenizer;

public class boj15552 {
    // 빠른 A+B
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()," ");
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
            //직접 sout(A+B)를 하는 것보다 더 빠름
        }   //BufferedWriter는 출력을 버퍼에 쌓아놓고 한 번에 출력하기 때문에 효율적인 입출력이 가능
        br.close();

        bw.flush();
        bw.close();


    }
}
