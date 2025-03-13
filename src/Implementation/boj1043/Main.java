package Implementation.boj1043;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 첫째 줄에 사람 수와 파티의 수 주어짐
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티의 수

        // 둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어짐
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        Set<Integer> truth = new HashSet<>(); // 진실을 아는 사람들 번호 담는 Set

        for (int i = 0; i < truthCount; i++) {
            truth.add(Integer.parseInt(st.nextToken()));
        }

        // 각 파티 정보를 저장할 리스트
        List<Set<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            Set<Integer> party = new HashSet<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        // 입력 확인 (디버깅 용도)
        // System.out.println("진실을 아는 사람들: " + truth);
        // System.out.println("파티 정보: " + parties);

        br.close();

        /*int result = 0;
        if (M == 0) result = M; // 진실 아는놈이 없는경우
        else {
            for (Set<Integer> check : parties) {

                // 현재 파티와 진실 집합의 교집합 확인
                if (Collections.disjoint(truth, check)) {
                    // 교집합이 없으면 거짓말이 가능한 파티
                    result++;
                } else {
                    // 교집합이 있으면 진실 집합을 갱신
                    truth.addAll(check);
                }

            }
        }
*/

        int result = 0;
        if (M == 0) {
            result = M; // 파티가 없는 경우
        } else {
            boolean updated;

            // 진실을 전파하는 과정 반복
            do {
                updated = false;
                for (Set<Integer> check : parties) {
                    // 현재 파티와 진실 집합의 교집합이 없다면
                    if (!Collections.disjoint(truth, check)) {
                        // 진실 집합을 갱신
                        if (truth.addAll(check)) {
                            updated = true; // 집합이 갱신되었음을 표시
                        }
                    }
                }
            } while (updated); // 더 이상 진실 집합이 갱신되지 않을 때까지 반복

            // 결과 계산: 거짓말이 가능한 파티 수
            for (Set<Integer> check : parties) {
                // 현재 파티와 진실 집합의 교집합이 없으면 거짓말 가능
                if (Collections.disjoint(truth, check)) {
                    result++;
                }
            }
        }

        System.out.println(result);

        // https://chatgpt.com/share/67402971-9ebc-800f-98d8-65e165bc5b6d
    }
}
