package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * <p>
 * Given a non-empty array of integers,
 * return the third maximum number in this array.
 * If it does not exist, return the maximum number.
 * The time complexity must be in O(n).
 * <p>
 * https://leetcode.com/problems/third-maximum-number/
 */
public class Q414_Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        Integer min = null, mid = null, max = null;
        int count = 0;

        for (Integer num : nums) {
            if (num.equals(max) || num.equals(mid) || num.equals(min))
                continue;

            if (max == null || num > max) {
                min = mid;
                mid = max;
                max = num;
                count++;
            } else if (mid == null || num > mid) {
                min = mid;
                mid = num;
                count++;
            } else if (min == null || num > min) {
                min = num;
                count++;
            }
        }
        if (count >= 3)
            return min;
        else
            return max;

    }
}
