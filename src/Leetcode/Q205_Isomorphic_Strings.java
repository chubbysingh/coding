package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 */
public class Q205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s == t)
            return true;
        else if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            if (map.containsKey(sc)) {
                if (!map.get(sc).equals(tc))
                    return false;
            } else {
                if (map.containsValue(tc))
                    return false;
                map.put(sc, tc);
            }
        }
        return true;
    }
}
