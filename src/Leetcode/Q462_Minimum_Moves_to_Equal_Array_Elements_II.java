package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q462_Minimum_Moves_to_Equal_Array_Elements_II {
    public int minMovesOne(int[] nums) {
        if (nums == null)
            return 0;

        Arrays.sort(nums);
        int midIndex = nums.length / 2;
        int result = 0;

        for (int n : nums) {
            result += Math.abs(n - nums[midIndex]);
        }
        return result;
    }

    public int minMOnesTwo(int[] nums) {
        if (nums == null)
            return 0;

        Arrays.sort(nums);
        int i = 0, j = nums.length;
        int result = 0;

        while (i < j) {
            result += nums[j] - nums[i];
            i++;
            j--;
        }
        return result;
    }
}
