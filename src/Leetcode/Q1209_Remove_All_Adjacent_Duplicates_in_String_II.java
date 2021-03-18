package Leetcode;

import java.util.Stack;

/**
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 *
 * It is guaranteed that the answer is unique.
 *
 */
public class Q1209_Remove_All_Adjacent_Duplicates_in_String_II {

    public String removeDuplicates(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i=0; i< s.length(); i++) {
            char c = s.charAt(i);

            if (sb.length() == 0 || c != sb.charAt(sb.length() - 1)) {
                sb.append(c);
                stack.push(1);
            } else {
                sb.append(c);
                stack.push(stack.peek() + 1);
            }

            if (stack.peek() == k) {
                for (int j=0; j < k; j++) {
                    stack.pop();
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q1209_Remove_All_Adjacent_Duplicates_in_String_II sol = new Q1209_Remove_All_Adjacent_Duplicates_in_String_II();

        String str = "deeedbbcccbdaa";
        String result = sol.removeDuplicates(str, 3);
        System.out.println(result);
    }
}
