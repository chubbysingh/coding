package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q132_Palindrome_Partitioning_II {
    public int minCut(String s) {
        int n = s.length();

        boolean dp[][] = new boolean[n][n];
        int cut[] = new int[n];

        for (int j = 0; j < n; j++) {
            cut[j] = j; //set maximum # of cut
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;

                    // if need to cut, add 1 to the previous cut[i-1]
                    if (i > 0) {
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    } else {
                        // if [0...j] is palindrome, no need to cut
                        cut[j] = 0;
                    }
                }
            }
        }

        return cut[n - 1];
    }
}
