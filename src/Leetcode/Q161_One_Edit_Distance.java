package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 */
public class Q161_One_Edit_Distance {
    public boolean isOneEditDistance(String s, String t) {
        // Both null, return true
        if(s == null || t == null)
            return false;

        int m = s.length();
        int n = t.length();

        // If length difference is greater than 1, return false
        if (Math.abs(m-n) > 1){
            return false;
        }

        int i=0;
        int j=0;
        int count=0;

        while(i < m && j < n){
            // If characters are same, increment both
            if(s.charAt(i)==t.charAt(j)){
                i++;
                j++;
            } else {
                // we need either of add, subtract or replace, sp increment count
                count++;
                if(count > 1)
                    return false;

                // If s is longest, increment i
                if(m > n){
                    i++;
                }
                // Else if t is longer, increment j
                else if (m<n) {
                    j++;
                }
                // Increment both
                else {
                    i++;
                    j++;
                }
            }
        }

        if (i < m || j < n){
            count++;
        }

        if (count == 1)
            return true;

        return false;
    }
}
