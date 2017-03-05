package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 */
public class Q003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int leftPointer=0,
                result = 0;

        for (int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);
            if (map.containsKey(c)) {
                // we need to take Math.max coz of cases like "abba" where left Pointer is already ahead
                leftPointer = Math.max(leftPointer, map.get(c) + 1);
            }
            map.put(c, i);
            int currLength = i - leftPointer + 1;
            result = Math.max(result, currLength);
        }
        return result;
    }
}
