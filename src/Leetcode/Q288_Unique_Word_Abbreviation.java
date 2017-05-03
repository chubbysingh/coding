package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * An abbreviation of a word follows the form
 * <first letter><number><last letter>.
 * Below are some examples of word abbreviations:
 * a) it                      --> it    (no abbreviation)
 * <p>
 * 1
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * <p>
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * <p>
 * Understand the problem:
 * The question is a little bit tricky.
 * There are only 2 conditions we return true for isUnique("word")
 * 1. The abbr does not appear in the dict.
 * 2. The abbr is in the dict && the word appears one and only once in the dict.
 */
public class Q288_Unique_Word_Abbreviation {
    private Set<String> uniqueDict;
    private Map<String, String> abbrDict;

    public Q288_Unique_Word_Abbreviation(String[] dictionary) {
        uniqueDict = new HashSet<>();
        abbrDict = new HashMap<>();

        for (String word : dictionary) {
            if (!uniqueDict.contains(word)) {
                String abbr = getAbbr(word);
                if (!abbrDict.containsKey(abbr)) {
                    abbrDict.put(abbr, word);
                } else {
                    abbrDict.put(abbr, "");
                }

                uniqueDict.add(word);
            }
        }
    }

    public boolean isUnique(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        String abbr = getAbbr(word);
        if (!abbrDict.containsKey(abbr) || abbrDict.get(abbr).equals(word)) {
            return true;
        } else {
            return false;
        }
    }

    private String getAbbr(String word) {
        if (word == null || word.length() < 3) {
            return word;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));

        return sb.toString();

    }
}
