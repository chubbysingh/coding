package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q074_Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i=0,
                j=matrix[0].length - 1;

        while (i < matrix.length && j >=0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }
}
