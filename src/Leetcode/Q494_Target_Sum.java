package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q494_Target_Sum {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    public static void main(String[] args) {
        int num[] = {1, 2, 3, 4, 5};
        int target=3;
        Q494_Target_Sum sol = new Q494_Target_Sum();
        int result = sol.findTargetSumWays(num, target);
        System.out.println(result);
    }
}
