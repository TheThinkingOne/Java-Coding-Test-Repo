package backTracking.boj2023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//백준 2023 신기한 소수

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> primeNum = List.of(2, 3, 5, 7);
        List<Integer> numList = new ArrayList<>();
        List<Integer> finalList = new ArrayList<>();

        for (int i = (int) Math.pow(10, N - 1); i < Math.pow(10, N); i++) {
            numList.add(i);
        }

        for (int j = 0; j < numList.size(); j++) {
            if (thinking(numList.get(j)) == N) {
                finalList.add(numList.get(j));
            }
        }

        finalList.sort(Integer::compareTo);
        for (int i : finalList) {
            System.out.println(i);
        }
    }

    private static int thinking(int number) {
        String numStr = Integer.toString(number);
        char[] digitList = numStr.toCharArray();
        int count = 0;
        String currentStr = "";
        List<Integer> newList = new ArrayList<>();

        for (char c : digitList) {
            currentStr += c;
            newList.add(Integer.parseInt(currentStr));
        }

        for (int j : newList) {
            if (isPrime(j)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}




