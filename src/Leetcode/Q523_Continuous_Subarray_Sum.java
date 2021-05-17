package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k,
 * return true if nums has a continuous subarray of size at least two
 * whose elements sum up to a multiple of k, or false otherwise.
 */
public class Q523_Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = k != 0 ? sum % k : sum;

            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }

            /*
            // Can be done like below as well
            if (map.containsKey(sum)
                    && i - map.get(sum) > 1) {
                return true;
            }
            // Do not override existing value in map.
            map.put (sum, map.getOrDefault (sum, i));
            */
        }
        return false;
    }

    public static void main(String[] args) {
        Q523_Continuous_Subarray_Sum sol = new Q523_Continuous_Subarray_Sum();

        int[] nums = {23,2,4,6,7};
        int k = 6;

        boolean result = sol.checkSubarraySum(nums, k);
        System.out.println(result);
    }
}
