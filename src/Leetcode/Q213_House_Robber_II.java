package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q213_House_Robber_II {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        // Rob the first house, not the last one.
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        dp[n] = dp[n - 1];

        // No rob the first, might or may not rob  the last one
        int[] dr = new int[n + 1];
        dr[0] = 0;
        dr[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            dr[i] = Math.max(dr[i - 1], dr[i - 2] + nums[i - 1]);
        }

        return Math.max(dp[n], dr[n]);
    }
}
