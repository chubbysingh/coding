package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q438_Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        int[] chars = new int[26];
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length())
            return result;
        for (char c : p.toCharArray())
            chars[c-'a']++;

        int start = 0, end = 0, count = p.length();
        // Go over the string
        while (end < s.length()) {
            // If the char at start appeared in p, we increase count
            if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
                count++;
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if (--chars[s.charAt(end++)-'a'] >= 0)
                count--;
            if (count == 0)
                result.add(start);
        }

        return result;
    }
}
