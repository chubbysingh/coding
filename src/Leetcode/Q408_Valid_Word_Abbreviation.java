package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a non-empty string s and an abbreviation abbr,
 * return whether the string matches with the given abbreviation.
 * <p>
 * A string such as "word" contains only the following valid abbreviations:
 * ["word", "1ord", "w1rd", "wo1d", "wor1",
 * "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string "word".
 * Any other string is not a valid abbreviation of "word".
 * <p>
 * Given s = "internationalization", abbr = "i12iz4n":
 * Return true.
 * <p>
 * Given s = "apple", abbr = "a2e":
 * Return false.
 */

public class Q408_Valid_Word_Abbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int idx1 = 0, idx2 = 0;

        while (idx1 < word.length() && idx2 < abbr.length()) {

            if (word.charAt(idx1) == abbr.charAt(idx2)) {
                idx1++;
                idx2++;
            }
            else if (!Character.isDigit(abbr.charAt(idx2))) {
                return false;
            }
            else {
                int num = 0;
                while (idx2 < abbr.length() && Character.isDigit(abbr.charAt(idx2))) {

                    // Stupid test case
                    if (num == 0 && abbr.charAt(idx2) == '0') return false;

                    num = num * 10 + (abbr.charAt(idx2) - '0');
                    idx2++;
                }
                idx1 += num;
            }
        }
        return idx1 == word.length() && idx2 == abbr.length();
    }

    public static void main(String[] args) {
        Q408_Valid_Word_Abbreviation sol = new Q408_Valid_Word_Abbreviation();
        System.out.println(sol.validWordAbbreviation("a", "01"));
    }
}
