package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q330_Patching_Array {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int count = 0;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss = miss + nums[i];
                i++;
            } else {
                miss += miss;
                count++;
            }
        }

        return count;
    }
}
