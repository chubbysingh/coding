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
        for (int n : nums) {
            for (int j = sum; j >= n; j--) {
                dp[j] = dp[j] || dp[j - n];
            }
        }
        return dp[sum];
    }
}
