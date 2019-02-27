package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between
 * a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 *
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 *
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single space.
 */
public class Q290_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] strArr = str.split(" ");

        if (pattern.length() != strArr.length)
            return false;

        for (int i=0; i<strArr.length; i++) {
            char c = pattern.charAt(i);
            String word = strArr[i];

            if(map.containsKey(c)) {
                if(!map.get(c).equals(word) )
                    return false;
            } else {
                if (set.contains(word))
                    return false;
                map.put(c, word);
                set.add(word);
            }
        }
        return true;
    }

    /**
     * This uses map.containsValue()
     * which has O(n) complexity
     */
    public boolean wordPatternOld(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();

        String[] strArr = str.split(" ");

        if (pattern.length() != strArr.length)
            return false;

        for (int i=0; i<strArr.length; i++) {
            Character c = pattern.charAt(i);
            String word = strArr[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word))
                    return false;
            } else {
                if (map.containsValue(word))
                    return false;
                map.put(c, word);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q290_Word_Pattern sol = new Q290_Word_Pattern();

        String pattern = "abba";
        String str = "dog cat cat dog";

        System.out.println(sol.wordPattern(pattern, str));
    }
}
