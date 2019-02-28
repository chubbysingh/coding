package Leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
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

    public static void main(String[] args) {
        Q001_Two_Sum sol = new Q001_Two_Sum();

        int[] arr = {1, 2, 3, 4, 5};
        int target = 7;

        int[] result = sol.twoSum(arr, target);
        System.out.println("Indices "+ result[0] + " and " + result[1] +
                " with values " + arr[result[0]] + " and " + arr[result[1]] + " add upto " +
                target);
    }
}
