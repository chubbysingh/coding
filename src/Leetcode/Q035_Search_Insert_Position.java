package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * https://leetcode.com/problems/search-insert-position/
 */
public class Q035_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int low = 0,
                high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
}
