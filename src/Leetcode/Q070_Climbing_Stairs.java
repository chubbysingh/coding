package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 */
public class Q070_Climbing_Stairs {
    public int climbStairs(int n) {
        int[] ways = new int[n];

        if (n <= 2) {
            return n;
        }

        ways[0] = 1;
        ways[1] = 2;

        for (int i = 2; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n - 1];
    }

    public int climbStairsEfficient(int n) {
        if (n <= 2) {
            return n;
        }

        int first = 1,
            second = 2;


        while(n > 2) {
            int third = first + second;
            first = second;
            second = third;

            n--;
        }

        return second;
    }

    public int climbStairsRecursive(int n) {

        if (n <= 2)
            return n;

        return climbStairsRecursive(n-1)
                + climbStairsRecursive(n-2);
    }
}
