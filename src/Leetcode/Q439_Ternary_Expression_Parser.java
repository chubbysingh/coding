package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a string representing arbitrarily nested ternary expressions,
 * calculate the result of the expression.
 * <p>
 * You can always assume that the given expression is valid
 * and only consists of digits 0-9, ?, :, T and F
 * (T and F represent True and False respectively).
 * <p>
 * Note:
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 * <p>
 * Example 1:
 * Input: "T?2:3"
 * Output: "2"
 * Explanation: If true, then result is 2; otherwise result is 3.
 * <p>
 * Example 2:
 * Input: "F?1:T?4:5"
 * Output: "4"
 * Explanation: The conditional expressions group right-to-left.
 * Using parenthesis, it is read/evaluated as:
 * <p>
 * "(F ? 1 : (T ? 4 : 5))"                   "(F ? 1 : (T ? 4 : 5))"
 * -> "(F ? 1 : 4)"                 or       -> "(T ? 4 : 5)"
 * -> "4"                                    -> "4"
 * <p>
 * Example 3:
 * Input: "T?T?F:5:3"
 * Output: "F"
 * Explanation: The conditional expressions group right-to-left.
 * Using parenthesis, it is read/evaluated as:
 * <p>
 * "(T ? (T ? F : 5) : 3)"                   "(T ? (T ? F : 5) : 3)"
 * -> "(T ? F : 3)"                 or       -> "(T ? F : 5)"
 * -> "F"                                    -> "F"
 */

public class Q439_Ternary_Expression_Parser {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) return "";
        Deque<Character> stack = new LinkedList<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {

                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();

                if (c == 'T') stack.push(first);
                else stack.push(second);
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }

    public static void main(String[] args) {
        Q439_Ternary_Expression_Parser sol = new Q439_Ternary_Expression_Parser();
        String res = sol.parseTernary("T?T?F:5:3");
        System.out.println(res);
    }
}
