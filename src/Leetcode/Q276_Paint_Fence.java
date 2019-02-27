package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 */
public class Q276_Paint_Fence {

    public int numWaysConstantSpace(int n, int k) {
        if (n <= 0 || k <= 0) {
            return 0;
        }

        // 0 ways to paint the 1st fence with same color (since there is no previous color)
        // k ways to paint the 1st fence with diff color
        int same = 0,
            diff = k,
            result = same + diff;

        for ( int i = 2 ; i <= n; ++ i) {
            same = diff; // same color as previous fence
            diff = result * (k - 1 ); //different color
            result = same + diff;
        }
        return result;
    }

    // DP
    public int numWays(int n, int k) {
        if (n <= 0 || k <= 0)
            return 0;

        if (n == 1)
            return k;

        // same[i] means the ith post has the same color with the (i-1)th post.
        int[] same = new int[n];
        // diff[i] means the ith post has a different color with the (i-1)th post.
        int[] diff = new int[n];

        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);

        for (int i = 2; i < n; ++i) {
            // the i-th in same should be equal the previous one in diff since only two consectutive
            // same are allowed
            same[i] = diff[i - 1];
            // the i-th in diff should be either different from its previous one or from the one
            // before the previous one
            diff[i] = (k - 1) * (same[i - 1] + diff[i - 1]);
        }
        return same[n - 1] + diff[n - 1];
    }


}
