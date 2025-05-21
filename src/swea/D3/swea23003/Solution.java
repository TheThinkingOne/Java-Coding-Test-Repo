package swea.D3.swea23003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        String[] palette = {"red","orange","yellow","green","blue","purple"};
        //Deque<String> deque = new ArrayDeque<>();

        Map<String, Integer> map = new HashMap<>();
        map.put(palette[0],0);
        map.put(palette[1],1);
        map.put(palette[2],2);
        map.put(palette[3],3);
        map.put(palette[4],4);
        map.put(palette[5],5);

        for (int i = 0; i < TC; i++) {
            char result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstColor = st.nextToken();
            String secondColor = st.nextToken();

            if (firstColor.equals(secondColor)) {
                result = 'E';
            }
            else {
                int firstColorIndex = map.get(firstColor);
                int secondColorIndex = map.get(secondColor);
                if (Math.abs(firstColorIndex - secondColorIndex) == 1 || Math.abs(firstColorIndex - secondColorIndex) == 5 ) {
                    result = 'A';
                }
                else if (Math.abs(firstColorIndex - secondColorIndex) == 3) {
                    result = 'C';
                }
                else {
                    result = 'X';
                }
            }

            System.out.println(result);



        }
    }
}
