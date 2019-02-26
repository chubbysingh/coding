package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 */
public class Q066_Plus_One {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            //if digit is '9', change it to '0'
            // e.g. [1, 9] --> [2, 0]
            digits[i] = 0;
        }

        //In case all digits are 9, control will come here
        //e.g. [9, 9, 9] --> [1, 0, 0, 0]
        int[] newnum = new int[digits.length + 1];
        newnum[0] = 1;
        return newnum;
    }
}
