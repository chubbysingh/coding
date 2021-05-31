package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class Q064_Minimum_Path_Sum {
    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i=0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (i==0 && j==0) {
                    dp[i][j] = grid[i][j];
                }

                else if (i == 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }

                else if (j == 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }

                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        Q064_Minimum_Path_Sum sol = new Q064_Minimum_Path_Sum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int result = sol.minPathSum(grid);
        System.out.println(result);
    }
}
