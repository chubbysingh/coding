package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 *
 */
public class Q276_Paint_Fence {

    /*
    The key to solve this problem is finding this relation.

    f(n) = (k-1)(f(n-1)+f(n-2))

    Assuming there are 3 posts, if the first one and the second one has the same color,
    then the third one has k-1 options. The first and second together has k options.
    If the first and the second do not have same color,
    the total is k * (k-1), then the third one has k options.
    Therefore, f(3) = (k-1)*k + k*(k-1)*k = (k-1)(k+k*k)
     */

    public int numWays(int n, int k) {
        int dp[] = {0, k , k*k, 0};

        if(n <= 2)
            return dp[n];

        for(int i = 2; i < n; i++){
            dp[3] = (k - 1) * (dp[1] + dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }

        return dp[3];
    }
}
