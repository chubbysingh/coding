package com.whitespace.raghav.Matrix;

/**
 * Created by rbhatnagar2 on 6/16/15.
 */
public class SpiralPrint {

    public static int[][] populateMatrix() {
        int[][] matrix = {
                {3, 5, 7, 9, 11, 13},
                {7, 14, 16, 18, 20, 25},
                {10, 20, 25, 30, 50, 70},
        };
        return matrix;
    }

    public static void printSpiral(int[][] matrix) {
        int startRow, endRow, startCol, endCol;
    }

    // Should print 3, 5, 7, 9, 11, 13, 25, 20, 18, 16, 14, 7, 10, 20, 25, 30, 50, 70
    public static void printSnake(int[][] matrix, int rowNum) {
        if (rowNum % 2 == 0) {
            //Print matrix[rowNum] from left to Right
            int start = 0, end = matrix[rowNum].length;
            while (start < end) {
                System.out.println(matrix[rowNum][start]);
                start++;
            }

        } else {
            //Print maxrix[rowNum] from right to left
            int start = matrix[rowNum].length - 1, end = 0;
            while (start >= end) {
                System.out.println(matrix[rowNum][start]);
                start--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = populateMatrix();

        for (int i = 0; i < matrix.length; i++) {
            printSnake(matrix, i);
        }
    }
}
