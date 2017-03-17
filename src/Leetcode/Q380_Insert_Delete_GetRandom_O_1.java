package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 *
 */
public class Q380_Insert_Delete_GetRandom_O_1 {
    private Map<Integer, Integer> map ;
    private List<Integer> list;
    java.util.Random rand = new java.util.Random();

    /** Initialize your data structure here. */

    public Q380_Insert_Delete_GetRandom_O_1() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set.
     * Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set.
     * Returns true if the set contained the specified element.
     **/
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        if(map.get(val) < list.size()-1) {
            int lastElement = list.get(list.size()-1);
            list.set(map.get(val), lastElement);
            map.put(lastElement, map.get(val));
        }
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
