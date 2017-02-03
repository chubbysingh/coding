package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q020_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> bracket = new Stack<Character>();

        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                bracket.push(getInverted(c));
            }
            else if (bracket.isEmpty() || bracket.pop() != c) {
                return false;
            }
        }
        return bracket.isEmpty();
    }

    private Character getInverted(Character c) {
        if (c == '(')
            return ')';
        else if (c == '{')
            return '}';
        else if (c == '[')
            return ']';
        else
            return null;
    }
}
