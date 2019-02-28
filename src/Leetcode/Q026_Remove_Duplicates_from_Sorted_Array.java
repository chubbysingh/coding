package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given a sorted array nums, remove the duplicates in-place such that
 * each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums
 * being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5, with the first five elements of nums
 * being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 *
 */
public class Q026_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return 1;

        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }

    public int removeDuplicatesSmart(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 1 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}
