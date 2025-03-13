package Implementation.two_pointer.example;

public class Main {
    public static void main(String[] args) {
        int N = 5; // 데이터의 개수 N
        int M = 5; // 찾고자 하는 부분합 M

        int count = 0;
        int intervalSum = 0;
        int end = 0;

        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = i+1;
        }

        for (int start = 0; start < N; start++) {
            while (intervalSum < M && end < N) {
                intervalSum += data[end];
                end += 1;
            }

            if (intervalSum == M) {
                count += 1;
            }
            intervalSum -= data[start];
        }

        System.out.println(count);
    }
}
