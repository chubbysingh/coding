package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q014_Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        StringBuilder sb = new StringBuilder();

        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        int i=0;

        while (i < first.length() && i < last.length()) {
            if (first.charAt(i) == last.charAt(i) ) {
                sb.append(first.charAt(i));
            } else {
                break;
            }
            i++;
        }
        return sb.toString();
    }
}
