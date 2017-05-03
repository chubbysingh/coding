package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q167_Two_Sum_II_Input_array_is_sorted {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target)
                return new int[]{start + 1, end + 1};
            else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }
}
