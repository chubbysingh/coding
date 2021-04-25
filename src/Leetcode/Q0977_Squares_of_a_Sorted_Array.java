package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 */
public class Q0977_Squares_of_a_Sorted_Array {
    public int[] sortedSquares(int[] nums) {

        // return null if array is null
        if (nums == null)
            return null;

        // initialize the result array
        int [] ans = new int[nums.length];

        // initialize start and end pointers to start and end index of array
        int start = 0, end = nums.length - 1;

        int i = end; // insert position.

        // Loop until start is less than equal to end
        while (start <= end) {

            // finding square of start and end element
            int pow1 = nums[start] * nums[start];
            int pow2 = nums[end] * nums[end];

            // if power of start is bigger,
            // ith element must be start element
            // increment start as we placed first negative number
            // else ith element will be end element
            if (pow1 > pow2) {
                ans[i--] = pow1;
                start++;
            } else {
                ans[i--] = pow2;
                end--;
            }
        }

        // return the result array
        return ans;
    }

    public static void main(String[] args) {
        Q0977_Squares_of_a_Sorted_Array sol = new Q0977_Squares_of_a_Sorted_Array();
        int[] nums = {-4, -1, 0, 3, 10};

        int[] result = sol.sortedSquares(nums);
        System.out.println(Arrays.toString(result));

    }
}
