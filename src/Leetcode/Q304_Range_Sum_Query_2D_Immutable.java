package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q304_Range_Sum_Query_2D_Immutable {
    private int[][] matrix;
    private int[][] sum;

    public Q304_Range_Sum_Query_2D_Immutable(int[][] matrix) {
        this.matrix = matrix;

        if (matrix == null || matrix.length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        sum = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] -
                        sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] -
                sum[row1][col2 + 1] + sum[row1][col1];
    }
}
