package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q349_Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();

        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {
            if (set.contains(n))
                intersect.add(n);
        }

        int[] res = new int[intersect.size()];
        int i = 0;
        for (Integer in : intersect) {
            res[i] = in;
            i++;
        }
        return res;
    }
}
