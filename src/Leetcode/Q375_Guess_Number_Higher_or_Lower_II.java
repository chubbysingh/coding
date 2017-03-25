package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n.
 * You have to guess which number I picked.
 * Every time you guess wrong,
 * I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x,
 * and you guess wrong, you pay $x.
 * You win the game when you guess the number I picked.
 *
 */
public class Q375_Guess_Number_Higher_or_Lower_II {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return solve(dp, 1, n);
    }

    int solve(int[][] dp, int L, int R) {
        if (L >= R) return 0;
        if (dp[L][R] != 0) return dp[L][R];
        dp[L][R] = Integer.MAX_VALUE;

        for (int i = L; i <= R; i++) {
            dp[L][R] = Math.min(dp[L][R], i + Math.max(solve(dp,L,i-1),solve(dp,i+1,R)));
        }
        return dp[L][R];
    }
}
