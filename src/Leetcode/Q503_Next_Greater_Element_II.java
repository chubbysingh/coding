package Leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by rbhatnagar2 on 2/11/17.
 */
public class Q503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] next = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }

    public static void main(String[] args) {
        Q503_Next_Greater_Element_II sol = new Q503_Next_Greater_Element_II();
        int[] result = sol.nextGreaterElements(new int[]{1, 3, 2, 4});
        for (int i : result) {
            System.out.println(i);
        }

    }
}
