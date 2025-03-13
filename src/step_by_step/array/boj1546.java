package step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄에서 정수 N을 입력받음
        int N = Integer.parseInt(br.readLine());

        // 두 번째 줄에서 공백으로 구분된 정수들을 입력받아 리스트에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arrayList.add(num);
        }

        // 리스트에서 최댓값을 찾음
        int maxNum = Collections.max(arrayList);

        // 모든 요소를 최댓값에 대한 상대적인 값으로 변환
        for (int i = 0; i < N; i++) {
            arrayList.set(i, arrayList.get(i) * 100 / maxNum);
        }

        // 변환한 값들의 평균을 구함
        float sum = 0;
        for (int num : arrayList) {
            sum += num;
        }
        float avgNum = sum / arrayList.size();

        System.out.println(avgNum);
    }
}

