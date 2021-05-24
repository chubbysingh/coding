package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0],
            min = nums[0],
            result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;

            max = getMaximum(max * nums[i], min * nums[i], nums[i]);
            min = getMinimum(temp * nums[i], min * nums[i], nums[i]);

            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    private int getMaximum(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    private int getMinimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String[] args) {
        Q152_Maximum_Product_Subarray sol = new Q152_Maximum_Product_Subarray();

        int[] nums = {2,3,-2,4};

        int result = sol.maxProduct(nums);
        System.out.println(result);
    }
}
