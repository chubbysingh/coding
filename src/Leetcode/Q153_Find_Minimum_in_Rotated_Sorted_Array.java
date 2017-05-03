package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q153_Find_Minimum_in_Rotated_Sorted_Array {
    public int findMinRecursive(int[] num) {
        return findMinRecursive(num, 0, num.length - 1);
    }

    public int findMinRecursive(int[] num, int left, int right) {
        // exit condition 1
        if (left == right)
            return num[left];

            // exit condition 2
        else if ((right - left) == 1)
            return Math.min(num[left], num[right]);

        // not rotated. Exit condition 3
        if (num[left] < num[right])
            return num[left];

        int middle = left + (right - left) / 2;

        // left is sorted, go right side
        if (num[middle] > num[left])
            return findMinRecursive(num, middle, right);

            // go left side
        else
            return findMinRecursive(num, left, middle);

    }

    public int findMinIterative(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        if (nums.length == 1)
            return nums[0];

        int left = 0;
        int right = nums.length - 1;

        //not rotated
        if (nums[left] < nums[right])
            return nums[left];

        while (left <= right) {
            if (right - left == 1) {
                return nums[right];
            }

            int m = left + (right - left) / 2;

            if (nums[m] > nums[right])
                left = m;
            else
                right = m;
        }

        return nums[left];
    }
}
