package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a string s and a string t, check if s is subsequence of t.
 *
 * A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 *
 * (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 *
 */
public class Q392_Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int indexS = 0, indexT = 0;

        while (indexT < t.length()) {
            if (t.charAt(indexT) == s.charAt(indexS)) {
                indexS++;
                if (indexS == s.length()) return true;
            }
            indexT++;
        }
        return false;
    }
}
