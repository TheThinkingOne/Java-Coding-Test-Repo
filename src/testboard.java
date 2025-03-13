import java.util.*;

public class testboard {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        // 문자열 추가
        sb.append("Hello, ");
        sb.append("world!");

        // 문자열 출력
        System.out.println(sb.toString()); // 출력: Hello, world!

        int K = (1 << 5) - 1;
        System.out.println(K);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);

        System.out.println(set.equals(set2));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        System.out.println(list.get(0));
        System.out.println(list.get(-1));



    }
}

