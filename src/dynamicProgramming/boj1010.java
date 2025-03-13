package dynamicProgramming;

//import java.util.Scanner;
//
//public class boj1010 {
//    static int west;
//    static int east;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        for (int i=0; i<N; i++) {
//            int count = 0;
//            west = sc.nextInt();
//            east = sc.nextInt();
//
//            int westFac = Factorial(west);
//            int eastFac = Factorial(east);
//            int diffFac = 0;
//
//            if (west==0 || east == 0) {
//                System.out.println(0);
//            }
//
//            else if (west==east) {
//                System.out.println(1);
//            }
//
//            else if (west > east) {
//                int diff = west - east;
//                diffFac = Factorial(diff);
//                count = westFac/(diffFac*eastFac);
//                System.out.println(count);
//            }
//
//            else if (west < east) {
//                int diff = east - west;
//                diffFac = Factorial(diff);
//                count = eastFac/(diffFac*westFac);
//                System.out.println(count);
//            }
//
//        }
//    }
//    private static int Factorial(int west, int east) {
//        if (num <= 1) return num;
//        else return Factorial(num-1)*num;
//    }
//}

//import java.util.Scanner;
//
//public class boj1010 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt(); // 테스트 케이스의 개수를 입력 받음
//        for (int t = 0; t < T; t++) { // 각 테스트 케이스에 대해 반복
//            int west = sc.nextInt(); // 서쪽 사이트의 개수 입력
//            int east = sc.nextInt(); // 동쪽 사이트의 개수 입력
//
//            int result = calculateBridge(west, east); // 다리를 놓는 방법 계산
//            System.out.println(result); // 결과 출력
//        }
//        sc.close();
//    }
//
//    private static int calculateBridge(int west, int east) {
//        // 서쪽 사이트의 개수가 동쪽 사이트의 개수보다 클 경우 서쪽 사이트 개수만큼 다리를 놓는 방법의 수를 구함
//        int count = 1;
//        for (int i = 0; i < west; i++) {
//            count *= (east - i);
//            count /= (i + 1);
//        }
//        return count;
//    }
//}

import java.util.Scanner;

public class boj1010 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 개수를 입력 받음
        for (int t = 0; t < T; t++) { // 각 테스트 케이스에 대해 반복
            int west = sc.nextInt(); // 서쪽 사이트의 개수 입력
            int east = sc.nextInt(); // 동쪽 사이트의 개수 입력

            int result = calculateBridge(west, east); // 다리를 놓는 방법 계산
            System.out.println(result); // 결과 출력
        }
        sc.close();
    }

    private static int calculateBridge(int west, int east) {
        // 서쪽 사이트의 개수가 동쪽 사이트의 개수보다 클 경우 서쪽 사이트 개수만큼 다리를 놓는 방법의 수를 구함
        if (west == east) {
            return 1; // 서쪽 사이트와 동쪽 사이트의 개수가 같을 경우 1 리턴
        } else if (west > east) {
            return calculateCombination(west, east); // 서쪽 사이트의 개수가 더 클 경우 조합을 계산하여 리턴
        } else { // west < east
            return calculateCombination(east, west); // 동쪽 사이트의 개수가 더 클 경우 조합을 계산하여 리턴
        }
    }

    private static int calculateCombination(int n, int r) {
        // 조합을 계산하는 메서드
        int numerator = 1;
        int denominator = 1;

        for (int i = 0; i < r; i++) {
            numerator *= (n - i);
            denominator *= (r - i);
        }

        return numerator / denominator;
    }
}

