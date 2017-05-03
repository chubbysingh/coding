package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Write a function to generate the generalized abbreviations of a word.
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1",
 * "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1",
 * "1o2", "2r1", "3d", "w3", "4"]
 * <p>
 * Understand the problem:
 * A classic dfs + backtracking problem. A trick here is if we've already abbrivate part of a word, we must jump at least a character.
 */

public class Q320_Generalized_Abbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();

        result.add(word);
        generateHelper(0, word, result);

        return result;
    }

    private void generateHelper(int start, String s, List<String> result) {
        if (start >= s.length()) {
            return;
        }

        for (int i = start; i < s.length(); i++) {
            for (int j = 1; i + j <= s.length(); j++) {
                String num = Integer.toString(j);
                String abbr = s.substring(0, i) + num + s.substring(i + j);
                result.add(abbr);
                generateHelper(i + 1 + num.length(), abbr, result); // skip 1b
            }
        }
    }
}
