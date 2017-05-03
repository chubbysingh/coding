package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q334_Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n == small || n == mid) {
                continue;
            } else if (n < small) {
                small = n;
            } else if (n < mid) {
                mid = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
