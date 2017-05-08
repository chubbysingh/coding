package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }
        return result;
    }
}
