package com.whitespace.raghav.Misc;

/**
 * Created by rbhatnagar2 on 12/15/15.
 */
public class ReverseInteger {
    public static int reverse(int num) {
        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
            num = -num;
        }
        int result = 0;
        while (num > 0) {
            result = result * 10 + num % 10;
            num /= 10;
        }
        return isNegative ? (0 - result) : result;
    }
}
