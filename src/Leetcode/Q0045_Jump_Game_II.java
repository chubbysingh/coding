package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q0045_Jump_Game_II {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = 0;
        int[] steps = new int[nums.length];
        steps[0] = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int n = nums[i];
            if (n + i > max) {
                int s = steps[i];
                for (int j = max + 1; j <= n + i; j++) {
                    if (j < steps.length) {
                        if (steps[j] == 0 || steps[j] > s + 1) {
                            steps[j] = s + 1;
                        }
                    }
                }
                max = n + i;
            }
        }
        return steps[steps.length - 1];
    }
}
