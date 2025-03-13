package Implementation.string.boj2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 처음엔 터널 입구 들어가는 순서대로
        // 두번짼 터널 출구 나오는 순서대로

        // A B C D  /  D A B C  => D 추월
        // A B C D E  /  B E D A C  => B,D,E 추월

        Stack<String> entranceCar = new Stack<>();
        int sonic = 0;

        int N = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            String enterCar = br.readLine();
            entranceCar.push(enterCar);
        }

        String temp = "";
        for (int i=0; i<N; i++) {
            String outCar = br.readLine();
            String enterCar = entranceCar.pop();
            if (!enterCar.equals(outCar)) {
                temp = enterCar;
            }
        }

        //System.out.println(entranceCar);


    }
}
