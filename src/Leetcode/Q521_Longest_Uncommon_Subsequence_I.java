package Leetcode;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q521_Longest_Uncommon_Subsequence_I {
    public int findLUSlength(String a, String b) {
        //Unless the 2 strings are equal, the string which is of a longer length will have the longest uncommon subsequence
        if (a.equals(b))
            return -1;
        else
            return Math.max(a.length(), b.length());
    }
}
