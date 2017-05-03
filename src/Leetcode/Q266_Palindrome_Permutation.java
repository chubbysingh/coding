package Leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Given a string, determine if a permutation of the string could form a palindrome.
 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */

public class Q266_Palindrome_Permutation {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);

            if (map.containsKey(letter)) {
                int count = map.get(letter) + 1;
                map.put(letter, count);
            } else {
                map.put(letter, 1);
            }
        }

        int tolerance = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();

            if ((int) pair.getValue() % 2 != 0) {
                tolerance++;
            }
        }

        if (s.length() % 2 == 0) {
            return tolerance == 0;
        } else {
            return tolerance == 1;
        }
    }
}
