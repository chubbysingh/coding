package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://leetcode.com/problems/jump-game/
 */
public class Q055_Jump_Game {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;

        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < i)
                return false;
            max = Math.max(max, i + nums[i]);

            if (max >= nums.length - 1)
                return true;
        }
        return false;
    }
}
