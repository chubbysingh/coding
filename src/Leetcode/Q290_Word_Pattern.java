package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q290_Word_Pattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();

        String[] strArr = str.split(" ");

        if (pattern.length() != strArr.length)
            return false;

        int i = 0;

        while (i < strArr.length) {
            Character c = pattern.charAt(i);
            String word = strArr[i];

            if (map.containsKey(c)) {
                if(!map.get(c).equals(strArr[i]))
                    return false;
            } else {
                if (map.containsValue(strArr[i]))
                    return false;
                map.put(c, word);
            }
            i++;
        }
        return true;
    }
}
