package Leetcode;

/**
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * https://leetcode.com/problems/jump-game/
 */

// https://www.youtube.com/watch?v=Zb4eRjuPHbM
public class Q055_Jump_Game {
    public boolean canJump(int[] nums) {
        int lastGoodIndexPosition = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndexPosition) {
                lastGoodIndexPosition = i;
            }
        }
        return lastGoodIndexPosition == 0;
    }

    public static void main(String[] args) {
        Q055_Jump_Game sol = new Q055_Jump_Game();

        int[] nums = {2,3,1,1,4};
        boolean result = sol.canJump(nums);

        System.out.println(result);
    }
}
