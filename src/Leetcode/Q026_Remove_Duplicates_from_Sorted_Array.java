package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q026_Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2)
            return 1;

        int curr = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[curr] = nums[i];
                curr++;
            }
        }
        return curr;
    }
}
