package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0039_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(nums);
        backtrack(list, 0, target, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, int start, int target, List<Integer> tempList, int[] nums) {
        if (target < 0)
            return;
        if (target == 0) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, i, target - nums[i], tempList, nums); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }

    }
}
