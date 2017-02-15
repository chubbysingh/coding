package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q201_Bitwise_AND_of_Numbers_Range {
    public int rangeBitwiseAnd(int m, int n) {
        //clear all rightmost bits for every numbers between m and n
        while (n > m) {
            n = n & (n-1);
        }
        // return AND of remaining.
        return m & n;
    }
}
