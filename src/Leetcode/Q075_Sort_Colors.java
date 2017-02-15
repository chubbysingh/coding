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

        int[] count = new int[3];

        for (int n=0; n<nums.length; n++) {
            count[nums[n]]++;
        }

        for (int i=1; i<3; i++) {
            count[i] += count[i-1];
        }

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
