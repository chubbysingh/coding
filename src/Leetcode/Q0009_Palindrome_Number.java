package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 */
public class Q0009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int magnitude = 1;
        while (x / magnitude >= 10) {
            magnitude = magnitude * 10;
        }

        while (x > 0) {
            int left = x / magnitude;
            int right = x % 10;

            if (left != right)
                return false;
            else {
                x = (x % magnitude) / 10;
                magnitude = magnitude / 100;
            }
        }
        return true;
    }
}
