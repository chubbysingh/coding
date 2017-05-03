package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q072_Edit_Distance {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null)
            return 0;
        else if (word1 == null || word2 == null)
            return word1 == null ? word2.length() : word1.length();

        int[][] T = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T[0].length; j++) {
                if (i == 0 && j == 0)
                    T[i][j] = 0;
                else if (i == 0)
                    T[i][j] = j;
                else if (j == 0)
                    T[i][j] = i;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    T[i][j] = T[i - 1][j - 1];
                else
                    T[i][j] = Math.min(T[i - 1][j - 1], Math.min(T[i - 1][j], T[i][j - 1])) + 1;
            }
        }
        return T[word1.length()][word2.length()];
    }
}
