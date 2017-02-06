package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        if (s == t)
            return true;
        else if (s.length() != t.length())
            return false;

        Map<Character, Character> map = new HashMap<Character, Character>();
        for (int i=0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);

            if (map.containsKey(sc)) {
                if (!map.get(sc).equals(tc))
                    return false;
            } else {
                if (map.containsValue(tc))
                    return false;
                map.put(sc, tc);
            }
        }
        return true;
    }
}
