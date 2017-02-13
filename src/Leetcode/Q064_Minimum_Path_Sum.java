package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * https://leetcode.com/problems/minimum-path-sum/
 * 
 */
public class Q064_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] T = new int[m][n];
        T[0][0] = grid[0][0];

        for (int i=1; i<m; i++) {
            T[i][0] = T[i-1][0] + grid[i][0];
        }
        for (int i=1; i<n; i++) {
            T[0][i] = T[0][i-1] + grid[0][i];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                T[i][j] = Math.min(T[i-1][j], T[i][j-1]) + grid[i][j];
            }
        }
        return T[m-1][n-1];
    }
}
