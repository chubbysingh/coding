package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 */
public class Q0044_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = trimStars(p).toCharArray(); // hack to remove edge cases


        boolean[][] T = new boolean[sArr.length + 1][pArr.length + 1];
        T[0][0] = true;

        if (pArr.length > 0 && pArr[0] == '*')
            T[0][1] = true;

        for (int i = 1; i <= sArr.length; i++) {
            for (int j = 1; j <= pArr.length; j++) {
                if (sArr[i - 1] == pArr[j - 1] || pArr[j - 1] == '?')
                    T[i][j] = T[i - 1][j - 1];
                else if (pArr[j - 1] == '*')
                    T[i][j] = T[i - 1][j] || T[i][j - 1];
                else
                    T[i][j] = false;
            }
        }
        return T[T.length - 1][T[0].length - 1];
    }

    private String trimStars(String p) {
        if (p.indexOf("**") == -1)
            return p;
        else {
            String pNew = p.replace("**", "*");
            return trimStars(pNew);
        }
    }
}
