package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {


        List<Integer>[] bucket = new List[nums.length + 1];
        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = buildMap(nums);

        for (int key : map.keySet()) {
            int frequency = map.get(key);

            if (bucket[frequency] == null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }

        for (int pos = bucket.length - 1; pos >= 0; pos--) {
            if (bucket[pos] != null) {
                for (int i = 0; i < bucket[pos].size() && res.size() < k; i++)
                    res.add(bucket[pos].get(i));
            }
        }
        return res;
    }

    private Map<Integer, Integer> buildMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int n : nums) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
        }
        return map;
    }
}
