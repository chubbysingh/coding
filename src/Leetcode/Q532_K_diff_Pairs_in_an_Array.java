package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 3/5/17.
 */
public class Q532_K_diff_Pairs_in_an_Array {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (map.get(key) >= 2) {
                    count++;
                }
            } else {
                int target = key + k;
                if (map.containsKey(target)) {
                    count++;
                }
            }
        }

        return count;
    }
}
