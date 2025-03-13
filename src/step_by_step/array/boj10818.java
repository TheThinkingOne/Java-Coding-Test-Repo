package step_by_step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arrN = new int[N];
        for (int i=0; i<N; i++) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int min = arrN[0];
        int max = arrN[0];

        // Iterate through the array to find min and max
        for (int i = 1; i < N; i++) {
            if (arrN[i] < min) {
                min = arrN[i];
            }
            if (arrN[i] > max) {
                max = arrN[i];
            }
        }

        // Print the results
        System.out.print(min + " ");
        System.out.print(max);

    }
}
