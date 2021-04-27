package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 */
public class Q0020_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(getInverted(c));
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
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
