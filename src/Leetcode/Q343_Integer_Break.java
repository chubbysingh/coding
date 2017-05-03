package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q343_Integer_Break {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j <= n) {
                    dp[i + j] = Math.max(dp[i + j],
                            Math.max(i, dp[i]) * Math.max(j, dp[j]));
                }
            }
        }
        return dp[n];
    }

    public int integerBreakTwo(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }

        if (n == 4) {
            return 4;
        }

        int result = 1;

        while (n > 4) {
            result *= 3;
            n -= 3;
        }

        result *= n;
        return result;
    }

    public static void main(String[] args) {
        Q343_Integer_Break sol = new Q343_Integer_Break();
        int n = 10;
        int res = sol.integerBreak(n);
        System.out.println(res);

    }
}
