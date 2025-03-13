package Implementation.boj1043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_re {
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
            result = M;
        } else {
            for (Set<Integer> check : parties) {
                Set<Integer> truthCopy = new HashSet<>(truth);
                truthCopy.removeAll(check);

                if (!truthCopy.equals(truth)) {
                    truth.addAll(check);
                }
            }

            for (Set<Integer> check : parties) {
                Set<Integer> checkCopy = new HashSet<>(check);
                checkCopy.removeAll(truth);

                if (checkCopy.equals(check)) {
                    result++;
                }
            }

        }

        System.out.println(result);


    }
}
