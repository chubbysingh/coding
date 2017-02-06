package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Set<Integer> _set = new HashSet<Integer>();

        for (int n: nums) {
            if(_set.contains(n))
                return true;
            else {
                _set.add(n);
            }
        }
        return false;
    }
}
