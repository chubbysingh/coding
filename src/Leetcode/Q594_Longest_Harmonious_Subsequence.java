package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 5/23/17.
 */
public class Q594_Longest_Harmonious_Subsequence {
    public int findLHS(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;
    }
}
