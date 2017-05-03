package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q376_Wiggle_Subsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Boolean flag = null;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && (flag == null || flag == nums[i] > nums[i - 1])) {
                flag = nums[i] < nums[i - 1];
                ans++;
            }
        }
        return ans;
    }
}
