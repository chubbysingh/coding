package com.whitespace.raghav.Matrix;

/**
 * Created by rbhatnagar2 on 6/16/15.
 * Search in a row wise and column wise sorted matrix
 */
public class Search {

    /**
     * @param matrix
     * @param x
     * @return
     */
    public static boolean isPresent(int[][] matrix, int x) {
        int rowNum = matrix.length; //3
        int colNum = matrix[0].length; //6

        int startRow = 0;

        while (startRow < rowNum && colNum > 0) {
            int numberToCompare = matrix[startRow][colNum - 1];
            if (numberToCompare == x) {
                return true;
            } else if (numberToCompare > x) {
                colNum--;
            } else {
                startRow++;
            }
        }

        return false;
    }

    public static int[][] populateMatrix() {
        int[][] matrix = {
                {3, 5, 7, 9, 11, 13},
                {7, 14, 16, 18, 20, 25},
                {10, 20, 25, 30, 50, 70},
        };
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = populateMatrix();

        if (isPresent(matrix, 8)) {
            System.out.println("Present");
        } else {
            System.out.println("Not Present");
        }
    }
}
