package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 *
 */
public class Q007_Reverse_Integer {
    public int reverse(int num) {
        boolean isNegative = false;

        if (num < 0) {
            isNegative = true;
            num = 0 - num;
        }

        int reverse = 0;

        while (num != 0) {
            if (reverse < Integer.MAX_VALUE / 10) {
                reverse = reverse * 10 + num % 10;
                num /= 10;
            } else {
                return 0;
            }
        }
        return isNegative ? 0 - reverse : reverse;
    }
}
