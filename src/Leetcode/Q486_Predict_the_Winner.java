package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q486_Predict_the_Winner {

    /*
     * dp[i][j] = max( min (dp[i + 1][j - 1], dp[i + 2][ j]) + v[i], min (dp[i][j - 2], dp[i + 1][ j - 1]) + v[j]})
     */
    public boolean PredictTheWinner(int[] nums) {

        int n = nums.length;
        int sum = 0;
        // If even, player 1 always wins
        if (n % 2 == 0)
            return true;

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
            sum += nums[i];
        }

        for (int j = 0; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int a = (i + 1 < n && j - 1 >= 0) ? dp[i + 1][j - 1] : 0;
                int b = (i + 2 < n) ? dp[i + 2][j] : 0;
                int c = (j - 2 >= 0) ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(Math.min(a, b) + nums[i], Math.min(a, c) + nums[j]);
            }
        }

        //dp[0][n - 1] is the max score player1 can get
        // return true if score is greater than half of sum
        return dp[0][n - 1] * 2 >= sum;
    }
}
