package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0018_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        Set<List<Integer>> set = new HashSet<List<Integer>>();

        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);

        for (int i=0; i<nums.length-3; i++) {

            for (int j=i+1; j<nums.length-2; j++) {

                int k = j+1;
                int l = nums.length-1;

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                    }
                    else if (sum < target)
                        k++;
                    else
                        l--;
                }

            }
        }
        result.addAll(set);
        return result;
    }
}
