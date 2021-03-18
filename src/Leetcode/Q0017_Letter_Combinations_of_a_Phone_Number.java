package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0017_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<String>();

        if (digits == null || digits.length() == 0) return result;

        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, 0, sb, dict, result);

        return result;
    }

    private void letterCombinationsHelper(String digits, int start, StringBuilder temp, String[] dict, List<String> result) {
        if (start >= digits.length()) {
            result.add(temp.toString());
            return;
        }

        // char to int
        int num = digits.charAt(start) - '0';
        String tuple = dict[num];
        for (int i = 0; i < tuple.length(); i++) {
            char c = tuple.charAt(i);
            temp.append(c);
            letterCombinationsHelper(digits, start + 1, temp, dict, result);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
