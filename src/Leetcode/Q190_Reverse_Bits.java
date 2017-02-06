package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q190_Reverse_Bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i=0; i < 32; i++) {
            res += (n & 1);
            n = n>>>1;
            if (i < 31)
                res = res << 1;
        }
        return res;
    }
}
