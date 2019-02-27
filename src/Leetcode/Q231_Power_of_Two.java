package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 2^0 = 1
 *
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 *
 * Example 3:
 * Input: 218
 * Output: false
 *
 */
public class Q231_Power_of_Two {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
