package Implementation.string.boj22233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 메모장에 적은 키워드 개수
        int M = Integer.parseInt(st.nextToken()); // 블로그에 쓴 글 개수

        // 키워드는 소문자와 숫자로만 이루어져 있습니다.
        //메모장에 있는 키워드 이름은 중복되지 않습니다.
        //글에 있는 키워드 이름은 중복되지 않습니다.
        // 그러나, 한 키워드는 여러 글에 있을 수 있습니다

        Set<String> keywordSet = new HashSet<>(); // 키워드 리스트
        Set<String> blogSet = new HashSet<>(); // 블로그 적을 것 리스트

        for (int i=0; i<N; i++) {
            keywordSet.add(br.readLine());
        }

        for (int i=0; i<M; i++) {
            String blogWord = br.readLine();
            st = new StringTokenizer(blogWord, ",");

            //Set<String> subSet = new HashSet<>(blogSet);

            /*while (st.hasMoreTokens()) {
                blogSet.add(st.nextToken());
            }*/
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                keywordSet.remove(token);
            }

            System.out.println(keywordSet.size());

        }

    }
}
