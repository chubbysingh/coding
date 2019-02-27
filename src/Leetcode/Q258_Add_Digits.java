package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 *
 * Example:
 *
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 *              Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 */
public class Q258_Add_Digits {
    public int addDigits(int num) {
        if (num < 10)
            return num;

        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        return addDigits(result);
    }

    // examples reveal this pattern
    public int addDigitsFollowup(int num) {
        if (num == 0){
            return 0;
        }
        int mod = num % 9;

        if (mod == 0)
            return 9;
        else
            return mod;
    }
}
