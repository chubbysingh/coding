package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Given an integer array nums, find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 */
public class Q053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0], maxHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(nums[i], maxHere + nums[i]);
            max = Math.max(max, maxHere);
        }
        return max;
    }
}
