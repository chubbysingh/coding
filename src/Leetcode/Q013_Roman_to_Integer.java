package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q013_Roman_to_Integer {
    public int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev=0;
        for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            int cur = map.get(c);

            if (prev > cur) {
                res -= cur;
            } else {
                res += cur;
            }
            prev = cur;
        }
        return res;
    }
}
