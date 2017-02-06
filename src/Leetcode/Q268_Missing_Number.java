package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q268_Missing_Number {
    public int missingNumber(int[] nums) {
        int res = nums.length;

        for (int i = 0 ; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
}
