package com.whitespace.raghav.Misc;

/**
 * Created by rbhatnagar2 on 12/15/15.
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int num) {

        if (num < 0) {
            return false;
        }

        int div = 1;
        while (num / div > 10) {
            div *= 10;
        }

        while (num != 0) {
            int left = num / div;
            int right = num % 10;
            if (left != right)
                return false;

            num = num % div;
            num = num / 10;

            div /= 100;

        }
        return true;
    }
}
