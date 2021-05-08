package Leetcode;

import java.util.Stack;

/**
 * Given a string S of lowercase letters,
 * a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
 *
 * Input: "abbaca"
 * Output: "ca"
 *
 */
public class Q1047_Remove_All_Adjacent_Duplicates_in_String {

    public String removeDuplicates(String S) {
        StringBuffer result = new StringBuffer();
        Stack<Character> stack = new Stack<>();

        for (Character c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public String removeDuplicatesAlternate(String S) {
        StringBuilder sb = new StringBuilder();
        for (char ch: S.toCharArray()) {
            if ( sb.length() != 0 && sb.charAt(sb.length() - 1) == ch ) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q1047_Remove_All_Adjacent_Duplicates_in_String sol = new Q1047_Remove_All_Adjacent_Duplicates_in_String();

        String str = "abbaca";
        String result = sol.removeDuplicates(str);
        System.out.println(result);
    }
}
