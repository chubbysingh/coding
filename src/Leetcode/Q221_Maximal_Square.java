package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length, result = 0;

        int[][] T = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (matrix[i - 1][j - 1] == '1') {
                    T[i][j] = Math.min(Math.min(T[i][j - 1], T[i - 1][j - 1]), T[i - 1][j]) + 1;

                    result = Math.max(T[i][j], result); // update result
                }
            }
        }
        return result * result;
    }
}
