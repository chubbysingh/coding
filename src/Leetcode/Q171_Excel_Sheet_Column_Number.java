package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q171_Excel_Sheet_Column_Number {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = 26 * result + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
