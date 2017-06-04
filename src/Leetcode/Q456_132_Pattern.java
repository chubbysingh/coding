package Leetcode;

import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q456_132_Pattern {
    class Pair {
        int min, max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack = new Stack();
        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek().min)
                stack.push(new Pair(n, n));
            else if (n > stack.peek().min) {
                Pair last = stack.pop();
                if (n < last.max) return true;
                else {
                    last.max = n;
                    while (!stack.isEmpty() && n >= stack.peek().max) stack.pop();
                    // At this time, n < stack.peek().max (if stack not empty)
                    if (!stack.isEmpty() && stack.peek().min < n) return true;
                    stack.push(last);
                }

            }
        }
        return false;
    }
}
