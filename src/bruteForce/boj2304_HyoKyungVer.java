package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2304_HyoKyungVer {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[1002]; // arr[i]번째는 해당 칸의 높이를 뜻함

        int maxH=0, maxL=0;
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 위치
            int H = Integer.parseInt(st.nextToken()); // 높이
            arr[L] = H;
            if(maxH<H){ // 최대 높이 찾기
                maxH = H; // 최대 높이
                maxL = L; // 최대 높이의 위치
            }
        }

        int sum=0;

        for(int i=1; i <= maxL; i++) { // 배열 내에서 최대 높이의 위치까지 스캔
            if(arr[i] <arr[i-1]) {
                arr[i] = arr[i-1];
            }
            sum+= arr[i];
        }

        for(int i=1000; i>maxL; i--){ // 끝에서부터 최대 높이 위치까지 반대로 스캔
            if(arr[i] <arr[i+1]){
                arr[i] = arr[i+1];
            }
            sum+=arr[i];
        }
        System.out.println(sum);


        //System.out.println(Arrays.toString(arr));
    }

}
