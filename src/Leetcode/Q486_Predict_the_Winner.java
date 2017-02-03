package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q486_Predict_the_Winner {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=0, maxHere=0;

        for (int n: nums) {
            if (n == 1) {
                maxHere++;
                max = maxHere > max ? maxHere : max;
            } else {
                maxHere=0;
            }
        }
        return max;
    }
}
