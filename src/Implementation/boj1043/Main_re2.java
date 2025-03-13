package Implementation.boj1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_re2 {
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

        br.close();

        int result = 0;

        if (M == 0) {
            result = M; // 파티가 없는 경우
        } else {
            boolean updated = true;

            // 진실 집합 확장을 반복하는 대신, 모든 파티를 여러 번 순회하며 한 번에 처리
            for (int i = 0; i < M; i++) {
                for (Set<Integer> check : parties) {
                    // 진실 집합과 현재 파티의 교집합 확인
                    boolean hasIntersection = false;
                    for (Integer person : check) {
                        if (truth.contains(person)) {
                            hasIntersection = true;
                            break;
                        }
                    }

                    if (hasIntersection) {
                        // 진실 집합 갱신
                        if (truth.addAll(check)) {
                            updated = true; // 갱신 표시
                        }
                    }
                }

                // 진실 집합이 더 이상 갱신되지 않으면 반복 종료
                if (!updated) break;
                updated = false; // 다음 순회를 위해 초기화
            }

            // 거짓말 가능한 파티 계산
            for (Set<Integer> check : parties) {
                boolean canLie = true;
                for (Integer person : check) {
                    if (truth.contains(person)) {
                        canLie = false;
                        break;
                    }
                }

                if (canLie) {
                    result++;
                }
            }
        }



    }
}
