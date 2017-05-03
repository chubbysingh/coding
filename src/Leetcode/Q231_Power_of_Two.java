package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
