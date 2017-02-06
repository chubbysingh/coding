package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q136_Single_Number {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x = x ^ n;
        }
        return x;
    }
}
