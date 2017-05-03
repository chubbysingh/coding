package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q368_Largest_Divisible_Subset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return result;

        Arrays.sort(nums);

        int[] t = new int[nums.length];
        int[] index = new int[nums.length];
        Arrays.fill(t, 1);
        Arrays.fill(index, -1);

        int max = 0;
        int maxIndex = -1;

        for (int i = 0; i < t.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && t[j] + 1 > t[i]) {
                    t[i] = t[j] + 1;
                    index[i] = j;
                }
            }

            if (max < t[i]) {
                max = t[i];
                maxIndex = i;
            }
        }

        int i = maxIndex;
        while (i >= 0) {
            result.add(nums[i]);
            i = index[i];
        }

        return result;
    }
}
