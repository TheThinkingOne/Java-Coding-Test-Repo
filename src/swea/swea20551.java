package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea20551 { // swea 20551 증가하는 사탕 수열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        for (int i = 0; i < TC; i++) {

            int result = 0;
            int[] list = new int[3];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            if (list[2] <=2 || (list[0] == 1 && list[1] == 1)) result = -1;
            else {
                /*if (list[0] < list[1] && list[1] < list[2]) {
                    result = 0;
                    break;
                }*/
                while (!(list[0] < list[1] && list[1] < list[2])) {
                    /*list[1] -= list[2] + 1;
                    result += list[2] + 1;
                    list[0] -= list[1] + 1;
                    result += list[1] + 1;*/
                    if (list[1] <= 0 || list[0] <= 0 || list[2] <= 0) {
                        result = -1;
                        break;
                    }

                    // list[1]이 음수 안 되게 조정
                    if (list[2] == list[1]) {
                        list[1] -= 1;
                        result++;
                    }
                    else {
                        list[1] -= (list[1] - list[2]) + 1; // 사탕을 제거할 때 0 이상을 유지하게 한다.
                        result += list[1] - list[2] + 1;
                    }

                    if (list[1] == list[0]) {
                        list[0] -= 1;
                        result += 1;
                    }
                    else {
                        // list[0]이 음수 안 되게 조정
                        list[0] -= (list[1] - list[0]) + 1;
                        result += list[1] - list[0] + 1;
                    }

                    // 조건을 만족하면 루프 종료
                    if (list[0] < list[1] && list[1] < list[2]) {
                        break;
                    }

                }
                /*else if (list[0] > list[1]) result += list[0] - list[1] + 1;*/
            }
            System.out.println("#" + (i+1) + " " + result);
        }

    }
}
