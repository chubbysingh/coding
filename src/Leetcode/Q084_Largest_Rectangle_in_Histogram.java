package Leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q084_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int height[]) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int area = 0;
        int i = 0;

        while (i < height.length) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to height[top] so get area by
                //height[top] * i;
                if (stack.isEmpty()) {
                    area = height[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to height[top]
                //so area = height[top]*(i - stack.peek() - 1);
                else {
                    area = height[top] * (i - stack.peek() - 1);
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            //if stack is empty means everything till i has to be
            //greater or equal to height[top] so get area by
            //height[top] * i;
            if (stack.isEmpty()) {
                area = height[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = height[top]*(i - stack.peek() - 1);
            else {
                area = height[top] * (i - stack.peek() - 1);
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String args[]) {
        Q084_Largest_Rectangle_in_Histogram mh = new Q084_Largest_Rectangle_in_Histogram();
        int input[] = {2, 2, 2, 6, 1, 5, 4, 2, 2, 2, 2};
        int maxArea = mh.largestRectangleArea(input);
        System.out.println(maxArea);
    }
}
