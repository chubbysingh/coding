package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * https://leetcode.com/problems/palindrome-number/
 *
 */
public class Q009_Palindrome_Number {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int digit = 1;
        while (x/digit >= 10) {
            digit = digit*10;
        }

        while(x > 0) {
            int left = x/digit;
            int right = x%10;

            if (left != right)
                return false;
            else {
                x = (x % digit) / 10;
                digit = digit/100;
            }
        }
        return true;
    }
}
