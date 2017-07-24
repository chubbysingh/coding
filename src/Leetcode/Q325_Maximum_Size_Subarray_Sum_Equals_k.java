package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.
 * <p>
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
 * <p>
 * Example 1:
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 */

public class Q325_Maximum_Size_Subarray_Sum_Equals_k {
    /*
     * We can first calculate the prefix sum of each number,
     * so sum(i, j) = sum(j) - sum(i - 1) = k.
     * Therefore, for each sum(j), we only need to check if there was a sum(i - 1)
     * which equals to sum(j) - k.
     * We can use a hash map to store the previous calculated sum.
     */

    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int sum = 0;
        //We need to put this entry into the map before, because
        // if the maximal range starts from 0, we need to calculate sum(j) - sum(i - 1).
        map.put(0, -1); // IMPORTANT


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }

        return maxLen;
    }
}
