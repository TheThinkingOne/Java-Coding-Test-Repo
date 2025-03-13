package Implementation.string.boj1541;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] charArray = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        boolean closeCount = false;
        int isClosed = 0;

        for (int i=0; i<charArray.length-1; i++) {
            char temp = charArray[i];
            char nextTemp = charArray[i+1];

            if (temp == '-') {
                sb.append(temp);
                sb.append('(');
                isClosed += 1;
            }

            else if (temp!='-' && nextTemp == '-') {
                sb.append(temp);
                if (closeCount == false) {
                    //sb.append(')');
                    closeCount = true;
                } else if (closeCount == true) {
                    sb.append(')');
                    isClosed -= 1;
                }
            }
            else {
                sb.append(temp);
            }
        }

        sb.append(charArray[charArray.length-1]);
        if (isClosed != 0) sb.append(')');
        //System.out.println(sb);

        String sbToStr = sb.toString();
        String[] minusArr = sbToStr.split("-");
        int result = 0;
        for (int i=0; i< minusArr.length; i++) {
            int sum = getSum(minusArr[i]);

            if(i==0) result = sum;
            else result -= sum;
        }

        System.out.println(result);

//        String str02 = sb.toString();
//
//        Stack<Integer> stack = new Stack<>();
//
//        int num = 0;
//        char sign = '+';
//
//        for (int i=0; i<str02.length(); i++) {
//            char c = str02.charAt(i);
//
//            if (Character.isDigit(c)) {
//                num
//            }
//        }


        //System.out.println(sb);
    }
    private static int getSum(String minusArr) {
        String[] plusArr = minusArr.split("\\+");
        int sum = 0;
        for (int j=0; j< plusArr.length; j++) {
            sum += Integer.parseInt(plusArr[j]);
        }
        return sum;
    }

}
