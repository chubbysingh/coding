package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q287_Find_the_Duplicate_Number {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0)
                return Math.abs(nums[i]);
            else {
                nums[Math.abs(nums[i])] *= -1;
            }
        }
        return -1;
    }
}
