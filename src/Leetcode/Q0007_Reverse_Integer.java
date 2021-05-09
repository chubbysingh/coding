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
public class Q0007_Reverse_Integer {
    public int reverse(int x) {
        //Corner case since Int range is from -2147483647 to 2147483646:
        if (Integer.MIN_VALUE == x)
            return 0;

        boolean isNegative = x < 0;
        x = Math.abs(x);

        int reverse = 0;

        while (x != 0) {
            if (reverse > Integer.MAX_VALUE/10) {
                return 0;
            }
            reverse = reverse * 10 + x%10;
            x = x/10;
        }
        return isNegative ? -1 * reverse : reverse;
    }

    public static void main(String[] args) {
        Q0007_Reverse_Integer sol = new Q0007_Reverse_Integer();
        int result = sol.reverse(-2147483648);
        System.out.println("Result: "  + result);
    }
}
