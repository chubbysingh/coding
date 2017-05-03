package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://leetcode.com/problems/first-missing-positive/
 */
public class Q041_First_Missing_Positive {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= 0 || nums[i] > nums.length)
                i++;
            else if (nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
            else
                i++;
        }

        i = 0;
        while (i < nums.length && nums[i] == i + 1)
            i++;
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q041_First_Missing_Positive sol = new Q041_First_Missing_Positive();

        int[] input = {-1, 4, 2, 1, 9, 10};
        System.out.println(sol.firstMissingPositive(input));
    }
}
