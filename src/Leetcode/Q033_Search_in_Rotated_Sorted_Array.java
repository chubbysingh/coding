package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q033_Search_in_Rotated_Sorted_Array {
    public int searchIterative(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int low = 0, high = nums.length-1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (nums[mid] == target)
                return mid;

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[high])
                    low = mid +1 ;
                else
                    high = mid - 1;
            }

        }
        return -1;
    }


    /* Recursive */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return -1;

        return binarySearch(nums, 0, nums.length-1, target);
    }
    public int binarySearch(int[] nums, int left, int right, int target){
        if(left>right)
            return -1;

        int mid = left + (right-left)/2;

        if(target == nums[mid])
            return mid;

        if(nums[left] <= nums[mid]){
            if(nums[left]<=target && target<nums[mid])
                return binarySearch(nums,left, mid-1, target);
            else
                return  binarySearch(nums, mid+1, right, target);

        } else {
            if(nums[mid]<target&& target<=nums[right])
                return  binarySearch(nums,mid+1, right, target);
            else
                return  binarySearch(nums, left, mid-1, target);
        }
    }
}
