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
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
            }
            else if (!Character.isDigit(abbr.charAt(j)))
                return false;

            else {
                int num = 0;
                while (Character.isDigit(abbr.charAt(j))) {
                    num = num*10 + Character.getNumericValue(abbr.charAt(j));
                    j++;
                }
                i += num;
            }

        }
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        Q408_Valid_Word_Abbreviation sol = new Q408_Valid_Word_Abbreviation();
        System.out.println(sol.validWordAbbreviation("internationalization", "i12iz4n"));
    }
}
