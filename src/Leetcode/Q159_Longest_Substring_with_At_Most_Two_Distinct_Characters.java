package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
 * For example, Given s = “eceba”,
 * T is "ece" which its length is 3.
 */
public class Q159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1)
            return 0;
        Map<Character, Integer> index = new HashMap<Character, Integer>();
        int lo = 0;
        int hi = 0;
        int maxLength = 0;
        while (hi < s.length()) {
            if (index.size() <= 2) {
                char c = s.charAt(hi);
                index.put(c, hi);
                hi++;
            }
            if (index.size() > 2) {
                int leftMost = s.length();
                for (int i : index.values()) {
                    leftMost = Math.min(leftMost, i);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                lo = leftMost + 1;
            }
            maxLength = Math.max(maxLength, hi - lo);
        }
        return maxLength;
    }
}
