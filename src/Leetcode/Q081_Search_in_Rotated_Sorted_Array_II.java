package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 *
 * Would this affect the run-time complexity? How and why?
 *
 */
public class Q081_Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;

        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target)
                return true;

            // Input contains duplicate
            // Left is sorted for sure...
            if (nums[low] < nums[mid] || nums[high] < nums[mid]) {
                if (nums[low] <= target && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            // Right is sorted for sure...
            else if (nums[mid] < nums[high] || nums[mid] < nums[low]) {
                if (nums[mid] < target && target <= nums[high])
                    low = mid +1 ;
                else
                    high = mid - 1;
            }
            //Something is equal
            else {
                high--;
            }

        }
        return false;
    }
}
