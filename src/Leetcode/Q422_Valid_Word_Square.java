package Leetcode;

import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a sequence of words, check whether it forms a valid word square.
 * <p>
 * A sequence of words forms a valid word square
 * if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
 *
 * e.g. following is a valid word square
 * [a b c d e f]
 * [b g h i j k]
 * [c h l m n o]
 * [d i m p q r]
 * [e j n q s t]
 * [f k o r t u]
 */
public class Q422_Valid_Word_Square {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return true;
        }
        // pre-compute the length. If length isnt equal return false
        int length = words.get(0).length();
        for (int i=1; i < words.size(); i++) {
            if (words.get(i).length() != length)
                return false;
        }

        // Now its a square matrix
        for (int i = 0; i < words.size(); i++) {
            String str = words.get(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != words.get(j).charAt(i))
                    return false;
            }
        }
        return true;
    }
}
