package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q191_Number_of_1_Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }
}
