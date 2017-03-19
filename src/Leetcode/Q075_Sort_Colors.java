package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * https://leetcode.com/problems/sort-colors/
 *
 */
public class Q075_Sort_Colors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        // Initialize counting array to all zeros.
        int[] count = new int[3];

        // Count the number of times each value occurs in the input.
        for (int n=0; n<nums.length; n++) {
            count[nums[n]]++;
        }

        // Modify the counting array to give the
        // number of values smaller than index
        for (int i=1; i<3; i++) {
            count[i] += count[i-1];
        }

        // Transfer numbers from input to output array
        // at locations provided by counting array
        int[] sorted = new int[nums.length];
        for (int i=0; i<sorted.length; i++) {
            int numToInsert = nums[i];
            int indexWhereInsert = count[numToInsert] - 1;

            sorted[indexWhereInsert] = numToInsert;
            count[numToInsert]--;
        }
        System.arraycopy(sorted, 0, nums, 0, nums.length);
    }
}
