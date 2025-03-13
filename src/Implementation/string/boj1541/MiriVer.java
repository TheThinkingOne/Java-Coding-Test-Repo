package Implementation.string.boj1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MiriVer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] minusArr = str.split("-"); // 뺄셈을 기준으로 1차적 분리
        System.out.println(Arrays.toString(minusArr)); // 55-50+40 을 기준으로 [55, 50+40]이 배열 안에 저장됨
        int result = 0;
        for (int i = 0; i < minusArr.length; i++) {
            int sum = getSum(minusArr[i]);  // 분리된 문자열의 각각에 포함된 정수 값들을 더해줌

            if (i == 0) result = sum;   // 첫 번째 수에서 빼줌
            else result -= sum;  // 각각 더해진 값들을 모두 빼줌
        }

        System.out.println(result);
    }

    private static int getSum(String minusArr) {
        String[] plusArr = minusArr.split("\\+");
        System.out.println(Arrays.toString(plusArr));
        int sum = 0;
        for (int j = 0; j < plusArr.length; j++) {
            sum += Integer.parseInt(plusArr[j]);
        }
        return sum;
    }

    // 입력값이 55-50+40 일 경우 : minusArr : [55, 50+40] , plusArr = [55], [50,40]
}
