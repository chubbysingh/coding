package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int j = i+1, k = nums.length-1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    if (!set.contains(Arrays.asList(nums[i], nums[j], nums[k]))) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
