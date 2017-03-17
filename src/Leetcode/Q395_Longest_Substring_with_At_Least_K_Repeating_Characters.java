package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q395_Longest_Substring_with_At_Least_K_Repeating_Characters {
    public int longestSubstring(String s, int k) {

        Map<Character, Integer> map = buildMap(s);
        Set<Character> splitSet = buildSet(map, k);

        if(splitSet.isEmpty()){
            return s.length();
        }

        int max = 0;
        int i=0;
        for (int j=0; j<s.length(); j++){
            char c = s.charAt(j);
            if(splitSet.contains(c)){
                max = Math.max(max, longestSubstring(s.substring(i, j), k));
                i=j+1;
            }
        }

        max = Math.max(max, longestSubstring(s.substring(i, s.length()), k));

        return max;
    }

    private Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c,1);
        }
        return map;
    }

    private Set<Character> buildSet(Map<Character, Integer> map, int k) {
        Set<Character> set = new HashSet<Character>();
        for (Character c : map.keySet()) {
            if (map.get(c) < k) {
                set.add(c);
            }
        }
        return set;
    }
}
