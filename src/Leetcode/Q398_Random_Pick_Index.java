package Leetcode;

import java.util.Random;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q398_Random_Pick_Index {
    Random r;
    int[] nums;

    public Q398_Random_Pick_Index(int[] nums) {
        r = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int index = 0;
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (r.nextInt(++times) == 0) {
                    index = i;
                }
            }
        }
        return index;
    }
}
