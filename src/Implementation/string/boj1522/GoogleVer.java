package Implementation.string.boj1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoogleVer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int min = Integer.MAX_VALUE;

        // Slicing Window?
        // 다음 배열의 값은 전 배열에서 처음 원소를 뺴고 다음에 들어올 원소 더하기
        // 교집합의 정보를 공유하고 차이가 나는 양쪽 끝 원소만 갱신하는 방법!!
        // 투 포인터 알고리즘과 연동하여 많이 쓰임

        int aCount = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'a') {
                aCount++;
            }
        }

        for (int i=0; i<str.length(); i++) {
            int bCount = 0;

            for (int j=i; j<i+aCount; j++) {
                int idx = j%str.length();
                if(str.charAt(idx) == 'b') {
                    bCount++;
                }
            }

            min = Math.min(min, bCount);
        }
        System.out.println(min);

    }
}
