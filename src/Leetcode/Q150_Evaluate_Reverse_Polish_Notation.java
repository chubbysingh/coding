package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * <p>
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
public class Q150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String c : tokens) {
            if (isOperator(c)) {
                int first = stack.pop();
                int second = stack.pop();
                int result = evaluate(first, second, c);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String c) {
        return (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/"));
    }

    private int evaluate(int first, int second, String c) {
        if (c.equals("+"))
            return first + second;
        else if (c.equals("-"))
            return second - first;
        else if (c.equals("*"))
            return first * second;
        else
            return second / first;
    }
}
