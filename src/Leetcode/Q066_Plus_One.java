package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q066_Plus_One {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newnum = new int[digits.length + 1];
        newnum[0] = 1;
        return newnum;
    }
}
