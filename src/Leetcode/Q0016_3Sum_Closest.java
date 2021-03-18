package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0016_3Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                } else {
                    if (sum > target)
                        k--;
                    else
                        j++;
                }
            }

        }
        return closest;
    }
}
