package Leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 0 || t < 0)
            return false;

        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];

            long leftBoundary = (long) curr - t;
            long rightBoundary = (long) curr + t + 1; //right boundary is exclusive, so +1
            SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
            if (sub.size() > 0)
                return true;

            set.add(curr);

            if (i >= k) { // or if(set.size()>=k+1)
                set.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
