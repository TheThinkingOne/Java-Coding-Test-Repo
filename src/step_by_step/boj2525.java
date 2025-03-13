package step_by_step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2525 {
    //백준 2525 오븐시계
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());

        int newMinute = minute + time;

        hour += newMinute / 60;
        minute = newMinute % 60;
        if (hour >= 24) {
            hour -= 24;
        }

        System.out.print(hour + " " + minute);
//        if (newMinute >= 60) {
//            int quotient = newMinute / 60;
//            int spare = newMinute % 60;
//            minute = spare;
//            hour += quotient;
//            if (hour >= 24) {
//                hour -= 24;
//            }
//        }


    }
}
