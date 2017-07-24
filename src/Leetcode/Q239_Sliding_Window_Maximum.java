package Leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            // Remove if the size of the deque is greater than k
            if (i - deque.getFirst() + 1 > k) {
                deque.removeFirst();
            }

            // Add into the result
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.getFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q239_Sliding_Window_Maximum sol = new Q239_Sliding_Window_Maximum();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k=3;

        int[] res = sol.maxSlidingWindow(nums, k);

        for (int n : res) {
            System.out.print(n + " ");
        }
    }
}
