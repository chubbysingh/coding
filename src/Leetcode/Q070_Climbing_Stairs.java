package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
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
}
