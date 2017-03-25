package Leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q084_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        if (height.length == 1) {
            return height[0];
        }

        Stack<Integer> stack = new Stack<Integer>();
        int[] copy = new int[height.length + 1];
        copy = Arrays.copyOf(height, height.length + 1);

        int maxArea = 0;
        int i = 0;

        while (i < copy.length) {
            if (stack.isEmpty() || copy[i] > copy[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int index = stack.pop();
                int localArea = copy[index] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, localArea);
            }
        }

        return maxArea;
    }
}
