package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Q0010_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // zero occurrence
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    //one occurrence. check previous chars
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] | dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }

    public static void main(String[] args) {
        Q0010_Regular_Expression_Matching sol = new Q0010_Regular_Expression_Matching();
        String pattern = "ab*a*c*a";
        String str = "aaa";
        boolean isMatch = sol.isMatch(str, pattern);
    }
}
