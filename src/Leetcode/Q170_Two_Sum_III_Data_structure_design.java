package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */


public class Q170_Two_Sum_III_Data_structure_design {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /*
     * Cheap Add: O(1)
     * Costly find: O(n)
     */
    public void add(int number) {
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    public boolean find(int value) {
        for (Integer num : map.keySet()) {
            int target = value - num;
            if (target == num) {
                if (map.get(target) > 1)
                    return true;
            }
            else if (map.containsKey(target)) {
                return true;
            }
        }
        return false;
    }

    /*
     * add : O(n)
     * find: O(1)
     */
    Set<Integer> sum = new HashSet<Integer>();
    Set<Integer> num = new HashSet<Integer>();

    // Add the number to an internal data structure.
    public void addTwo(int number) {
        if (num.contains(number)) {
            sum.add(number * 2);
        } else {
            for (int n : num) {
                sum.add(n + number);
            }
            num.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean findTwo(int value) {
        return sum.contains(value);
    }
}
