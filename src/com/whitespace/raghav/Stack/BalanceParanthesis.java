package com.whitespace.raghav.Stack;

import java.util.Stack;

/**
 * Check for balanced parentheses in an expression
 * Created by rbhatnagar2 on 10/16/15.
 */
public class BalanceParanthesis {
    public static boolean hasMatchingParenthesis(String str) {
        if (str == null || str.length() == 0)
            return true;

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if (!isMatching(pop, c))
                    return false;
            }
        }
        return true;
    }

    private static boolean isMatching(char c1, char c2) {
        if (c1 == '(' && c2 == ')')
            return true;
        else if (c1 == '[' && c2 == ']')
            return true;
        else if (c1 == '{' && c2 == '}')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String str = "[()]{}[()()]()}";
        boolean isMatching = hasMatchingParenthesis(str);
        System.out.println(isMatching);
    }
}
