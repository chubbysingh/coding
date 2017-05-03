package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q227_Basic_Calculator_II {

    public int calculate(String s) {

        if (s == null || s.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c)) || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
    }

    public static void main(String[] args) {
        Q227_Basic_Calculator_II sol = new Q227_Basic_Calculator_II();
        String s = "1*2-3/4+5*6-7*8+9/10";
        int result = sol.calculate(s);
        System.out.println(result);
    }
}
