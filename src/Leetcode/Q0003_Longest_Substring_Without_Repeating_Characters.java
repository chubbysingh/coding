package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Q0003_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int leftPointer = 0,
                result = 0;

        for (int i = 0; i < str.length(); i++) {
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

    public static void main(String[] args) {
        Q0003_Longest_Substring_Without_Repeating_Characters sol = new Q0003_Longest_Substring_Without_Repeating_Characters();
        String str = "abcdeafghijk";
        int length = sol.lengthOfLongestSubstring(str);
        System.out.println("Length: " + length);
    }
}
