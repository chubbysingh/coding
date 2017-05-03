package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
