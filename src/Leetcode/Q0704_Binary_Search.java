package Leetcode;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target,
 * write a function to search target in nums. If target exists, then return its index.
 * Otherwise, return -1.
 */
public class Q0704_Binary_Search {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target)
                return mid;
            if (target < nums[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q0704_Binary_Search sol = new Q0704_Binary_Search();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        int result = sol.search(nums, target);
        System.out.println(result);
    }
}
