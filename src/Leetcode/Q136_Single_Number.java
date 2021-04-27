package Leetcode;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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
