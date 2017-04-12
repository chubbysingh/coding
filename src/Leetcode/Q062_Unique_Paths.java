package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * https://leetcode.com/problems/unique-paths/
 *
 */
public class Q062_Unique_Paths {
    public int uniquePaths(int m, int n) {

        int[][] T = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 || j == 0)
                    T[i][j] = 1;
                else
                    T[i][j] = T[i-1][j] + T[i][j-1];
            }
        }
        return T[m-1][n-1];
    }
}
