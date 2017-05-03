package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q172_Factorial_Trailing_Zeroes {
    public int trailingZeroes(int n) {
        int result = 0;

        while (n > 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
