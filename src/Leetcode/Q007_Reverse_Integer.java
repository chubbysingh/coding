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
    public int reverse(int x) {
        long num = (long) x;
        boolean isNegative = false;

        if (num < 0) {
            isNegative = true;
            num = 0 - num;
        }

        long reverse = 0;

        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        if (isNegative)
            reverse = -1 * reverse;

        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE)
            return 0;
        else
            return (int) reverse;
    }

    public static void main(String[] args) {
        Q007_Reverse_Integer sol = new Q007_Reverse_Integer();
        int result = sol.reverse(123);
        System.out.println("Result: "  + result);
    }
}
