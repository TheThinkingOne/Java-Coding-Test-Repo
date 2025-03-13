package backTracking.boj2023;

import java.io.BufferedReader;
import java.util.Scanner;

public class HyoKyungVer {
    //백준 2023 신기한 소수

    static int N;
    static int[] oddNum = {1,3,5,7,9};
    static StringBuilder sb;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); // 예제에서 4

        sb = new StringBuilder();
        getPrimeNumber(2, 1);
        getPrimeNumber(3, 1);
        getPrimeNumber(5, 1);
        getPrimeNumber(7, 1);

        System.out.println(sb);

    }

    private static void getPrimeNumber(int now, int cnt) {

        if(cnt== N){
            sb.append(now+"\n");
            return;
        }
        for(int i=0;i<5;i++){
            int newNumber = now*10+oddNum[i]; //21 33 79 ... etc
            // 2 => 23 => 233 => 2333
            boolean result = realPrime(newNumber);
            if(result) getPrimeNumber(newNumber, cnt+1);
        }

    }

    private static boolean realPrime(int num) {
        // 불러온 숫자를 홀수로 나눠서 소수인지 판별하는 메서드 realPrime
        for(int i=3; i<= Math.sqrt(num); i=i+2){ // Math.sqrt(25) = 5.0, i=i+2는 i를 2씩 증가
            if(num%i==0) return false;
        }
        return true;
    }
}
