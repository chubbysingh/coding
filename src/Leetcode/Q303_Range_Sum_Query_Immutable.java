package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q303_Range_Sum_Query_Immutable {
    int[] nums;
    public Q303_Range_Sum_Query_Immutable(int[] nums) {
        for(int i=1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return nums[j];
        } else {
            return nums[j] - nums[i-1];
        }
    }
}
