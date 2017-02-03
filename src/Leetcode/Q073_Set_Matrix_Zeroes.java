package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q073_Set_Matrix_Zeroes {
    public void setZeroes(int[][] matrix) {
        boolean[] rowCount = new boolean[matrix.length];
        boolean[] colCount = new boolean[matrix[0].length];

        for (int i=0; i < matrix.length; i++) {
            for (int j=0 ; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowCount[i] = true;
                    colCount[j] = true;
                }
            }
        }

        for (int i=0; i < matrix.length; i++) {
            for (int j=0 ; j < matrix[0].length; j++) {
                if (rowCount[i] || colCount[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
