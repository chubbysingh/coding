package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a list of words and two words word1 and word2,
 * return the shortest distance between these two words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */

public class Q243_Shortest_Word_Distance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            if (word1.equals(currentWord)) {
                word1Index = i;
                if (word2Index != -1)
                    min = Math.min(min, word1Index - word2Index);
            } else if (word2.equals(currentWord)) {
                word2Index = i;
                if (word1Index != -1)
                    min = Math.min(min, word2Index - word1Index);
            }
        }

        return min;
    }
}
