package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q187_Repeated_DNA_Sequences {

    /**
     * Convert 10 letter string to an integer.
     * Denote A as 00, C as 01, G as 10, and T as 11
     * 10 letter string can be converted to a 20 byte number
     * <p>
     * Use hashset to add that number and compare with other substrings
     */
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<String>();

        if (s == null || s.length() < 9)
            return result;

        // Used to check if we have encountered the number before
        Set<Integer> words = new HashSet<Integer>();

        // Used to avoid duplicates
        Set<Integer> seen = new HashSet<Integer>();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        for (int i = 0; i < s.length() - 9; i++) {
            int value = 0;
            for (int j = i; j < i + 10; j++) {
                int tempValue = map.get(s.charAt(j));
                value = value << 2;
                value = value | tempValue;
            }

            if (!words.contains(value))
                words.add(value);
            else {
                if (!seen.contains(value)) {
                    seen.add(value);
                    result.add(s.substring(i, i + 10));
                }
            }
        }
        return result;
    }


    public List<String> findRepeatedDnaSequencesBruteForce(String s) {
        Set<String> set = new HashSet<String>();
        Set<String> repeated = new HashSet<String>();

        List<String> ans = new LinkedList<String>();

        for (int i = 0; i < s.length() - 9; i++) {

            String k = s.substring(i, i + 10);

            if (!set.contains(k)) {
                set.add(k);
            }
            // Its repeated. Check for duplication
            else if (!repeated.contains(k)) {
                repeated.add(k);
                ans.add(k);
            }
        }
        return ans;
    }


}
