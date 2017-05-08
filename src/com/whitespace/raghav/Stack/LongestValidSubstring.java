package com.whitespace.raghav.Stack;

import java.util.Stack;

/**
 * Given a string consisting of opening and closing parenthesis,
 * find length of the longest valid parenthesis substring.
 * <p>
 * Created by rbhatnagar2 on 10/16/15.
 */
public class LongestValidSubstring {
    private static int longestValidSubstring(String str) {
        if (str == null || str.length() == 0)
            return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;

        stack.push(-1);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                stack.push(i); //Push index of opening bracket
            else {
                // We found a closing bracket
                stack.pop();
                if (!stack.isEmpty()) {
                    int currResult = i - stack.peek();
                    result = currResult > result ? currResult : result;
                } else {
                    stack.push(i);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "(((((())))))";
        System.out.println(longestValidSubstring(str));
    }

}
