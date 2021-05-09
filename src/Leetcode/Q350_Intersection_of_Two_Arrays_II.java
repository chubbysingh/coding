package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q350_Intersection_of_Two_Arrays_II {
    public int[] intersect(int[] nums1, int[] nums2) {

        // buildMap
        Map<Integer, Integer> map = buildMap(nums2);

        // buildList
        List<Integer> res = new LinkedList<>();
        for (int n : nums1) {
            if (map.containsKey(n) && map.get(n) != 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        //return an array from the list
        int[] result = new int[res.size()];
        int index = 0;
        for (int i : res) {
            result[index] = i;
            index++;
        }
        return result;

    }

    private Map<Integer, Integer> buildMap(int[] num) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        return map;
    }
}
