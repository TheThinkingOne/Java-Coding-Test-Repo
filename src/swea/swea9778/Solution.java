package swea.swea9778;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int TC = Integer.parseInt(br.readLine());
        for (int i=1; i<=TC; i++) {
            int N = Integer.parseInt(br.readLine());
//            Map<Integer, Integer> DeckMap = new HashMap<Integer, Integer>(); // 키 밸류
//            List<Integer> Drawed = new ArrayList<>();
//            for (int j=2; j<= 11; j++) {
//                if (j<=9) {
//                    for (int k=1; k<=4; k++) {
//                        DeckMap.put(k, j);
//                    }
//                }
//                else if (j==10) {
//                    for (int k=1; k<=16; k++) {
//                        DeckMap.put(k, j);
//                    }
//                }
//                else {
//                    for (int k=1; k<=4; k++) {
//                        DeckMap.put(k, j);
//                    }
//                }
//            }
//
//            int sum = 0;
//
//            for (int j=0; j<N; j++) {
//                int currentDraw = Integer.parseInt(br.readLine());
//                if (DeckMap.containsKey(currentDraw)) { // 현재 뽑은 카드가 있으면
//                    DeckMap.remove(j);
//                }
//            }
            Map<Integer, Integer> deck = new HashMap<>();
            for (int j=2; j<=11; j++) {
                if (j<=9) deck.put(j,4);
                else if (j==10) deck.put(j,16);
                else if (j==11) deck.put(j,4);
            }

            int sum = 0;
            int over = 0;
            int good = 0;

            for (int j=0; j<N; j++) {
                int drawed = Integer.parseInt(br.readLine());
                sum += drawed;
                deck.put(drawed, deck.get(drawed)-1); // 2 뽑으면 (2,4) 에서 (2,3) 됨 카드 수 차감
            }

            for (int card = 2; card <= 11; card ++) {
                int count = deck.getOrDefault(card,0);
                if (count==0) continue;

                if (sum + card > 21) over += count;
                else good += count;
            }

            if (over >= good) System.out.println("#" + i + " " + "STOP");
            else System.out.println("#" + i + " " + "GAZUA");

        }
    }
}
