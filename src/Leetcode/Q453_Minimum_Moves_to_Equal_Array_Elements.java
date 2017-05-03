package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q453_Minimum_Moves_to_Equal_Array_Elements {
    public int minMoves(int[] nums) {
        int min = getMinimum(nums);

        int result = 0;
        for (int n : nums) {
            result += n - min;
        }
        return result;
    }

    private int getMinimum(int[] nums) {
        int min = nums[0];

        for (int n : nums) {
            min = Math.min(min, n);
        }
        return min;
    }
}
