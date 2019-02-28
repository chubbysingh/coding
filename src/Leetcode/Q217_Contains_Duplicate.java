package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 */
public class Q217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Set<Integer> _set = new HashSet<Integer>();

        for (int n : nums) {
            if (_set.contains(n))
                return true;
            else {
                _set.add(n);
            }
        }
        return false;
    }
}
