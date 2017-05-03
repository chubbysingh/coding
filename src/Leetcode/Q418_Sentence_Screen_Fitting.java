package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a rows x cols screen and a sentence represented by a list of words,
 * find how many times the given sentence can be fitted on the screen.
 * <p>
 * Note:
 * <p>
 * A word cannot be split into two lines.
 * The order of words in the sentence must remain unchanged.
 * Two consecutive words in a line must be separated by a single space.
 * Total words in the sentence won't exceed 100.
 * Length of each word won't exceed 10.
 * 1 ≤ rows, cols ≤ 20,000.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * rows = 2, cols = 8, sentence = ["hello", "world"]
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * hello---
 * world---
 * <p>
 * The character '-' signifies an empty space on the screen.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * a-bcd-
 * e-a---
 * bcd-e-
 * <p>
 * The character '-' signifies an empty space on the screen.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input:
 * rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * I-had
 * apple
 * pie-I
 * had--
 * <p>
 * The character '-' signifies an empty space on the screen.
 */
public class Q418_Sentence_Screen_Fitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int m = sentence.length;
        int res = 0;
        int c = 0;
        int left = cols;
        for (int i = 0; i < rows; ) {
            if (sentence[c % m].length() <= left) {
                if (c % m == m - 1) res++;
                c++;
                left = left - sentence[(c - 1) % m].length() - 1;

            } else {
                i++;
                left = cols;
            }
        }
        return res;
    }
}
