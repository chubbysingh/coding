package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * This is a follow-up problem of Shortest Word Distance.
 * The only difference is now word1 could be the same as word2.
 * <p>
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 * <p>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 */
public class Q245_Shortest_Word_Distance_III {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0)
            return -1;

        if (word1 == null || word2 == null)
            return -1;

        boolean isSame = false;

        if (word1.equals(word2))
            isSame = true;

        int shortest = Integer.MAX_VALUE;

        int prev = -1;
        int i1 = -1;
        int i2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (isSame) {
                if (words[i].equals(word1)) {
                    if (prev != -1) {
                        shortest = Math.min(shortest, i - prev);
                    }
                    prev = i;
                }
            } else {
                if (word1.equals(words[i])) {
                    i1 = i;
                    if (i2 != -1) {
                        shortest = Math.min(shortest, i - i2);
                    }
                } else if (word2.equals(words[i])) {
                    i2 = i;
                    if (i1 != -1) {
                        shortest = Math.min(shortest, i - i1);
                    }
                }
            }
        }

        return shortest;
    }
}
