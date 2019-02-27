package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 *
 * Example 2:
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 *
 * Example 3:
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */
public class Q263_Ugly_Number {
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        else if (num == 1)
            return true;
        else if (num % 2 == 0)
            return isUgly(num / 2);
        else if (num % 3 == 0)
            return isUgly(num / 3);
        else if (num % 5 == 0)
            return isUgly(num / 5);
        else
            return false;
    }

    public boolean isUglyTwo(int num) {
        if (num == 0)
            return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
