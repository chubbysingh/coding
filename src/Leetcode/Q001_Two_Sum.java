package Leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 */
public class Q001_Two_Sum {

    // If not sorted. Add it to a Map and check
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            //first num : nums[i]
            // second num: target - nums[i]
            int secondNum = target - nums[i];

            if (map.containsKey(secondNum)) {
                return new int[]{i, map.get(secondNum)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    //If sorted, compare start and end
    public int[] twoNumsIfSorted(int[] nums, int target) {
        int start = 0,
                end = nums.length - 1;

        while (start < end) {
            int computedNum = nums[start] + nums[end];
            if (target == computedNum) {
                return new int[]{start, end};
            } else {
                if (target < computedNum) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return null;
    }
}
