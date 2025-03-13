package Implementation.string.boj1213;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] charArray = str.toCharArray();
        Set<Character> charSet = new HashSet<>();

        if (charArray.length % 2 == 0) {
            for (int i=0; i<charArray.length; i++) {
                char temp = charArray[i];
                if (!charSet.contains(temp)) charSet.add(charArray[i]);

            }
        }

        else {

        }

    }
}
