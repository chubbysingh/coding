package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q076_Minimum_Window_Substring {
    public String minWindow(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0) {
            return "";
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int start = 0, end=0, minStart=0,minLen = Integer.MAX_VALUE, counter = T.length();
        while(end < S.length())
        {
            char c1 = S.charAt(end);
            if(map.containsKey(c1) ) {
                if (map.get(c1) > 0)
                    counter--;
                map.put(c1,map.get(c1)-1);
            }


            end++;

            while(counter == 0)
            {
                if(minLen > end-start)
                {
                    minLen = end-start;
                    minStart = start;
                }

                char c2 = S.charAt(start);
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2)+1);

                    if(map.get(c2) > 0)
                        counter++;
                }


                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : S.substring(minStart,minStart+minLen);
    }

    public static void main(String[] args) {
        Q076_Minimum_Window_Substring sol = new Q076_Minimum_Window_Substring();
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String res = sol.minWindow(S, T);
        System.out.println(res);
    }
}
