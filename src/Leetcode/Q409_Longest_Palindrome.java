package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q409_Longest_Palindrome {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        int res = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                res += 2;
            } else {
                set.add(c);
            }
        }

        if (set.size() > 0) {
            res += 1;
        }

        return res;
    }
}
