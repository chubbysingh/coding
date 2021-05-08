package Leetcode;

/**
 * Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 */
public class Q0766_Toeplitz_Matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q0766_Toeplitz_Matrix sol = new Q0766_Toeplitz_Matrix();

        int[][] matrix = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};

        boolean result = sol.isToeplitzMatrix(matrix);
        System.out.println(result);
    }
}
