package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q416_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volume = 0;
        for (int num : nums) {
            volume += num;
        }
        if (volume % 2 != 0) {
            return false;
        }
        volume /= 2;
        return isSubsetSum(nums, volume);
    }

    public boolean isSubsetSum(int[] nums, int sum) {
        // dp def
        boolean[] dp = new boolean[sum + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i-1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[sum];
    }
}
