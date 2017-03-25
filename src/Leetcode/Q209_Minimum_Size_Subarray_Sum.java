package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q209_Minimum_Size_Subarray_Sum {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (hi < nums.length) {
            // Moves the hi pointer
            while (hi < nums.length && sum < s) {
                sum += nums[hi];
                hi++;
            }

            // Move the lo pointer
            while (lo <= hi && sum >= s) {
                minLen = Math.min(minLen, hi - lo);
                sum -= nums[lo];
                lo++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }
    }
}
