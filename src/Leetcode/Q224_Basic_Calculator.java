package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q224_Basic_Calculator {
    public int calculate(String s) {
        int sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int sum = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    sum = sum*10 + (s.charAt(i+1) - '0');
                    i++;
                }
                result = result + sign * sum;
            }

            else if (c == '+')
                sign = 1;

            else if (c == '-')
                sign = -1;

            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }

            else if (c == ')') {
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q224_Basic_Calculator sol = new Q224_Basic_Calculator();

        String num = "2-(5-6)";

        int result = sol.calculate(num);
        System.out.println(result);
    }
}
