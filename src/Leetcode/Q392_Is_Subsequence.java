package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
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
