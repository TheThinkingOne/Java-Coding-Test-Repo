package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int trd = Integer.parseInt(st.nextToken());

        int price = 0;

        if (one == two && two == trd) {
            price = 10000 + one*1000;
        }

        else if (one == two || one == trd || two == trd) {
            if (one == two || one == trd) {
                price = 1000 + one*100;
            }
            else if (two == trd) {
                price = 1000 + two*100;
            }
        }

        else if (one != two && one != trd && two != trd) {
            int maxNum = Math.max(Math.max(one,two),trd);
            price = maxNum * 100;
        }

        System.out.println(price);
    }
}
