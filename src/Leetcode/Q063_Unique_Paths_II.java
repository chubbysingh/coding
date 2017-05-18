package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q063_Unique_Paths_II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        int[][] T = new int[m][n];

        T[0][0] = 1;
        for(int i=1; i<m; i++) {
            // if there is an obstacle at that point, # ways is 0
            T[i][0] = obstacleGrid[i][0] == 1 ? 0 : T[i-1][0];
        }
        for(int i=1; i<n; i++) {
            // if there is an obstacle at that point, # ways is 0
            T[0][i] = obstacleGrid[0][i] == 1 ? 0 : T[0][i-1] ;
        }
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                // if there is an obstacle at that point, # ways is 0
                T[i][j] = obstacleGrid[i][j] == 1 ? 0 : T[i-1][j] + T[i][j-1];
            }
        }
        return T[m-1][n-1];
    }
}
