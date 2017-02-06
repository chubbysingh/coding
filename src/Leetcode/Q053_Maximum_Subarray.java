package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q053_Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int max=nums[0], maxHere=nums[0];

        for (int i=1; i < nums.length; i++) {
            maxHere = Math.max(nums[i], maxHere + nums[i]);
            max = Math.max(max, maxHere);
        }
        return max;
    }
}
