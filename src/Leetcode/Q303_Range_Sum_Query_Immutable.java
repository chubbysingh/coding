package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given an integer array nums,
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 *
 */
public class Q303_Range_Sum_Query_Immutable {
    int[] nums;

    public Q303_Range_Sum_Query_Immutable(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return nums[j];
        } else {
            return nums[j] - nums[i - 1];
        }
    }

    public static void main(String[]args) {
        int[] nums = new int[] {-2, 0, 3, -5, 2, -1};
        Q303_Range_Sum_Query_Immutable sol =
                new Q303_Range_Sum_Query_Immutable(nums);

        System.out.println(sol.sumRange(0, 2)); //1
        System.out.println(sol.sumRange(2, 5)); //-1
        System.out.println(sol.sumRange(0, 5)); //-3

    }
}
