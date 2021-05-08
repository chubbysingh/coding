package Leetcode;

import java.util.Stack;

/**
 * Given two strings s and t, return true if they are equal
 * when both are typed into empty text editors. '#' means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 */
public class Q0844_Backspace_String_Compare {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Q0844_Backspace_String_Compare sol = new Q0844_Backspace_String_Compare();

        boolean result = sol.backspaceCompare("y#fo##f", "y#f#o##f");
        System.out.println(result);
    }
}
