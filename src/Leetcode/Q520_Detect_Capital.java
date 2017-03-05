package Leetcode;

/**
 * Created by rbhatnagar2 on 3/5/17.
 */
public class Q520_Detect_Capital {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0)
            return true;

        int upperCaseCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                upperCaseCount++;
        }
        if (upperCaseCount == 0 || upperCaseCount == word.length())
            return true;
        if (upperCaseCount == 1 && Character.isUpperCase(word.charAt(0)))
            return true;
        return false;
    }
}
