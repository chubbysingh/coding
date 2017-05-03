package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q442_Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();

        for (int n : nums) {
            // number would be nums[i]
            // number with index nums[i] would be nums[Math.abs(nums[i]) - 1]
            int index = Math.abs(n) - 1;
            if (nums[index] < 0)
                result.add(Math.abs(n)); // This is duplicate
            else
                nums[index] *= -1;
        }
        return result;
    }
}
