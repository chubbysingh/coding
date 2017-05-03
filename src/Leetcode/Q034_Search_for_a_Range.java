package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q034_Search_for_a_Range {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return new int[]{-1, -1};

        int[] res = new int[2];
        res[0] = binarySearchFirst(nums, target);

        if (res[0] == -1) {
            res[1] = -1;
            return res;
        }

        res[1] = binarySearchLast(nums, target);
        return res;
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                high = mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (nums[low] == target)
            return low;
        return -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            //for finding the right index, making id more towards right
            // so that it does not stuck at infinite loop
            int mid = 1 + low + (high - low) / 2;
            if (nums[mid] == target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (nums[high] == target)
            return high;

        return -1;
    }
}
