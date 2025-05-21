package swea.D3.swea22795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            String line = br.readLine();
            List<Integer> list = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int[] arr = new int[6];
            long arrSum = 0;
            for (int j=0; j<6; j++) {
                arr[j] = list.get(j);
                arrSum += list.get(j);
            }

            Arrays.sort(arr);
            long maxInarr = arr[5];
            //System.out.println(maxInarr);

            while (true) {
                maxInarr++;
                long currentSum = arrSum + maxInarr;
                if (currentSum % 7 == 0) break;
            }

            System.out.println(maxInarr);

        }
    }
}
