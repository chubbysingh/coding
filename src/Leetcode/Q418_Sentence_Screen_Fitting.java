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

    /*
    We first concatenate all strings together and add spaces between words.
    This string is the actual length we need to fit the string.
    Now we have a pos variable that initializes to 0, this is the position in the All string.
    Now for each row, we add cols to pos, this is the position in the All string that we can fit in the row.
    If the pos in the All string is pointing to a white space,
    we know we have just fitted (at least partial) strings in it.
    pos increment by 1.

    If its a letter, we know its in the middle of the word,
    so we need to decrease the pos to the start of the word.
    Here using pos % len indicates if pos is larger than len,
    it will go back to a position in the string.
     */

    public int wordsTyping(String[] sentence, int rows, int cols) {
        String all = "";
        for (String s : sentence) {
            all += s + " ";
        }
        int pos = 0;
        int len = all.length();
        for (int i = 0; i < rows; i++) {
            pos += cols;
            if (all.charAt(pos % len) == ' ') {
                pos++;
            } else {
                while (pos > 0 && all.charAt((pos - 1) % len) != ' ') {
                    pos--;
                }
            }
        }
        return pos / len;
    }
}
