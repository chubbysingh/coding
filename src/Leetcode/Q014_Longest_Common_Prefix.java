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

    /**
     * Horizontal Scan
     */
    public String longestCommonPrefixHorizontalScan(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * Vertical Scan
     */
    public String longestCommonPrefixVerticalScan(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * Divide and Conquer Solution
     */

    public String longestCommonPrefixDivideAndConquer(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix(strs, l , mid);
            String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }
}
