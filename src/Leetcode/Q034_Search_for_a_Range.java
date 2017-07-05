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
        int low=0, high = nums.length-1;
        while (low <= high) {
            if (nums[low] == target)
                return low;

            int mid = low + (high-low)/2;
            if (nums[mid] == target)
                high = mid;
            else if (nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }

        return -1;
    }

    private int binarySearchLast(int[] nums, int target) {
        int low=0, high=nums.length-1;
        while (low <= high) {
            if (nums[high] == target)
                return high;

            int mid = 1 + low + (high - low) / 2;
            if (nums[mid] == target) {
                low = mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q034_Search_for_a_Range sol = new Q034_Search_for_a_Range();
        int[] num = {1};
        int target = 1;
        int[] res = sol.searchRange(num, target);
        System.out.println("[ "+res[0] + ", " + res[1] + " ]");

    }
}
