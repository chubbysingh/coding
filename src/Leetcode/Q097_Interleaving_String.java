package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q097_Interleaving_String {
    public static boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length(), length2 = s2.length(), length3 = s3.length();
        if (length3 != length1 + length2)
            return false;
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++)
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i)) ? true : false;
        for (int i = 1; i <= length2; i++)
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i)) ? true : false;
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
