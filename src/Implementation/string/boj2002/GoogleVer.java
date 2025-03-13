package Implementation.string.boj2002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class GoogleVer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 처음엔 터널 입구 들어가는 순서대로
        // 두번짼 터널 출구 나오는 순서대로
        // A B C D  /  D A B C  => D 추월
        // A B C D E  /  B E D A C  => B,D,E 추월

        int N = Integer.parseInt(br.readLine());
        LinkedHashMap<String, Integer> enterCar = new LinkedHashMap<>();
        // String 이 키, Integer 가 value
        // 일반 해시맵으로 저장하면 순서 기억하지 않음, LinkedHashMap 사용해야함

        for (int i = 0; i < N; i++) {
            enterCar.put(br.readLine(), i);
        }

        /*ZG508OK -> 0
        PU305A  -> 1
        RI604B  -> 2
        ZG206A  -> 3
        ZG232ZF -> 4*/
        //System.out.println(enterCar);
        // 출차 차량 순서 PU305A ZG232ZF ZG206A ZG508OK RI604B

        int count = 0;
        for (int i = 0; i < N; i++) {
            String outCar = br.readLine();

            Iterator<String> iterator = enterCar.keySet().iterator();
            // enterCar 해시맵의 키값을 가져옴?
            while (iterator.hasNext()) {
                if (enterCar.get(outCar) > enterCar.get(iterator.next())) {
                    count++;
                    break;
                }
            }
            enterCar.remove(outCar);
        }
        System.out.println(count);
    }
}
