package Leetcode;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q566_Reshape_the_Matrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c != m * n)
            return nums;
        int[][] reshaped = new int[r][c];
        for (int i = 0; i < r * c; i++)
            reshaped[i / c][i % c] = nums[i / n][i % n];
        return reshaped;
    }
}
