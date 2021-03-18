package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0032_Longest_Valid_Parentheses {

    /**
     * DP Solution
     * dp[i] means longest valid substring starting from i to the end
     * So, if s.charAt(i) == ')', dp[i] = 0 since longest valid substring cannot start from ')'
     * if s.chatAt(i) == '(', we check dp[i+1] to get the longest valid parenthesis
     * and jump to its index to check if i + dp[i+1] 's char is ')'
     * <p>
     * Also, after checking dp[j], check dp[j+1] since that can be a valid string as well
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()];
        int maxLen = 0;

        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                int j = i + dp[i + 1] + 1;
                if (j < s.length() && s.charAt(j) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    if (j + 1 < s.length()) {
                        dp[i] += dp[j + 1];
                    }
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
