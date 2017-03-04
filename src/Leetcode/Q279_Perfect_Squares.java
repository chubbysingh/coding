package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 */
public class Q279_Perfect_Squares {

    public int numSquares(int n) {
        if (n < 1)
            return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i=1; i<=n ;i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j=1; j<=n; j++) {
                if (i - j*j < 0)
                    break;
                int possibleValue = dp[i - j*j] + 1;
                dp[i] = Math.min(dp[i], possibleValue) ;
            }
        }
        return dp[n];
    }
}
