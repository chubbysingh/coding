package Leetcode;

/**
 * Given an array of integers nums, calculate the pivot index of this array.
 *
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the index's right.
 *
 * If the index is on the left edge of the array,
 * then the left sum is 0 because there are no elements to the left.
 * This also applies to the right edge of the array.
 *
 * Return the leftmost pivot index. If no such index exists, return -1.
 */
public class Q0724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int sum = 0,
            leftSum = 0;

        for (int n : nums) {
            sum += n;
        }

        for (int i=0; i < nums.length; i++) {
            if (i > 0) {
                leftSum += nums[i-1];
            }

            int rightSum = sum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Q0724_Find_Pivot_Index sol = new Q0724_Find_Pivot_Index();

        int[] nums = {1,7,3,6,5,6};

        int result = sol.pivotIndex(nums);
        System.out.println(result);
    }
}
