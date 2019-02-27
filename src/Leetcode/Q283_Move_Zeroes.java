package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class Q283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int currIndex = 0; currIndex < nums.length; currIndex++) {
            if (nums[currIndex] != 0) {
                nums[nonZeroIndex] = nums[currIndex];
                nonZeroIndex++;
            }
        }
        //filling rest of the array with zeros
        for (int j = nonZeroIndex; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public static void main(String[] args) {
        Q283_Move_Zeroes sol = new Q283_Move_Zeroes();

        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);

        // Result: [1, 3, 12, 0, 0]
        for (int n : nums) {
            System.out.print(n + ", ");
        }
    }
}
