package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q240_Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int row=0,
            col=matrix[0].length - 1;

        while (row < matrix.length && col >=0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}
