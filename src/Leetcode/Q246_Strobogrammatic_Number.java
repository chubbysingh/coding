package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).
 * <p>
 * Write a function to determine if a number is strobogrammatic.
 * The number is represented as a string.
 * <p>
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */

public class Q246_Strobogrammatic_Number {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');

        int start = 0,
            end = num.length() - 1;

        while (start <= end) {
            //if start or end digits are not in map, return false
            if (!map.containsKey(num.charAt(start))
                || !map.containsKey(num.charAt(end)))
                return false;

            if (num.charAt(start) != map.get(num.charAt(end)))
                return false;

            start++;
            end--;
        }
        return true;
    }
}
