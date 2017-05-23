package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 5/23/17.
 */
public class Q575_Distribute_Candies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
}
