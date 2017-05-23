package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 2/11/17.
 */
public class Q506_Relative_Ranks {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            if (i == nums.length-1)
                result[map.get(nums[i])] = "Gold Medal";
            else if (i == nums.length-2)
                result[map.get(nums[i])] = "Silver Medal";
            else if (i == nums.length-3)
                result[map.get(nums[i])] = "Bronze Medal";
            else
                result[map.get(nums[i])] = (nums.length - i)+"";
        }
        return result;
    }
}
