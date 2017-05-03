package Leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;

        boolean[] dp = new boolean[s.length() + 1];

        //Empty string is a word
        dp[0] = true;

        // <= because substring does not include the last index
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String subString = s.substring(j, i);
                if (dp[j] && wordDict.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Q139_Word_Break sol = new Q139_Word_Break();

        List<String> wordDict = Arrays.asList(new String[]{"Leet", "Code"});
        boolean isExist = sol.wordBreak("LeetCode", wordDict);
        System.out.println(isExist);
    }
}
