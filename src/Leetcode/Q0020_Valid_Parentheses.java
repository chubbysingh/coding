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
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if ( stack.isEmpty() || !isMatch(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(Character open, Character close) {
        if (open == '(') {
            return close == ')';
        } else if (open == '{') {
            return close == '}';
        } if (open == '[') {
            return close == ']';
        }
        return false;
    }

    public static void main(String[] args) {
        Q0020_Valid_Parentheses sol = new Q0020_Valid_Parentheses();

        boolean result = sol.isValid("()");
        System.out.println(result);
    }
}
