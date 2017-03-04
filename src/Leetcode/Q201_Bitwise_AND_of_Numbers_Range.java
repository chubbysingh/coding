package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q201_Bitwise_AND_of_Numbers_Range {

    // Better clearer solution
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;

        while (m != n) {
            shift++;
            m = m >> 1;
            n = n >> 1;
        }

        return m << shift;
    }

    // Tricky
    public int rangeBitwiseAndTwo(int m, int n) {
        //clear all rightmost bits for every numbers between m and n
        while (n > m) {
            n = n & (n-1);
        }
        // return AND of remaining.
        return m & n;
    }
}
