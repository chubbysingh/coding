package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q300_Longest_Increasing_Subsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;
        }

        for (int i=1; i<nums.length; i++) {
            for (int j=0; j<i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return maximum(dp);
    }
    private int maximum(int[] arr) {
        int max = arr[0];

        for(int x:arr) {
            max = x > max ? x : max;
        }
        return max;
    }
}
