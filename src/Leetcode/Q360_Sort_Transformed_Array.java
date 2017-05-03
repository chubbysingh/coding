package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a sorted array of integers nums and integer values a, b and c.
 * Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.
 * <p>
 * The returned array must be in sorted order.
 * <p>
 * Expected time complexity: O(n)
 * <p>
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 * <p>
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5Result: [-23, -5, 1, 7]
 */

public class Q360_Sort_Transformed_Array {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int nextIndex = 0;
        if (a > 0 || (a == 0 && b >= 0))
            nextIndex = nums.length - 1;
        if (a < 0 || (a == 0 && b < 0))
            nextIndex = 0;
        double mid = -1 * ((b * 1.0) / (2.0 * a));
        while (start <= end) {
            if (a > 0 || (a == 0 && b >= 0)) {
                if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
                    int x = nums[start++];
                    result[nextIndex--] = a * x * x + b * x + c;
                } else {
                    int x = nums[end--];
                    result[nextIndex--] = a * x * x + b * x + c;
                }
            } else if (a < 0 || (a == 0 && b < 0)) {
                if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
                    int x = nums[start++];
                    result[nextIndex++] = a * x * x + b * x + c;
                } else {
                    int x = nums[end--];
                    result[nextIndex++] = a * x * x + b * x + c;
                }
            }
        }
        return result;
    }
}
