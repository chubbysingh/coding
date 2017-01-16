package com.whitespace.raghav.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 9/8/15.
 * Length of the longest substring without repeating characters
 */
public class LongestSubstring {

    private static int getLongestLength(String input) {
        if (input == null || input == "")
            return 0;

        int start = 0, end = 0, maxCount = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i=0 ; i< input.length(); i++) {
            Character c = input.charAt(i);

            if (!map.containsKey(c) || (map.containsKey(c) && start > map.get(c)) ) {
                end++;
                map.put(c, i);
            } else {
                int currentLength = end - start;
                if (currentLength > maxCount) {
                    maxCount = currentLength;
                }

                start = map.get(c) + 1;
            }

        }

        maxCount = end - start > maxCount ? end-start : maxCount;
        return maxCount;
    }

    public static void main(String[] args) {
        String input = "BBBB";
        System.out.println(getLongestLength(input));

        String input2 = "ABCDEFEG";
        System.out.println(getLongestLength(input2));
    }
}
