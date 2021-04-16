package Leetcode;

import java.util.Map;

/**
 * Given a string s and an integer array indices of the same length.
 *
 * The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
 *
 * Return the shuffled string.
 *
 */
public class Q1428_Leftmost_Column_with_at_Least_a_One {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);

        // Set pointers to the top-right corner.
        int currentRow = 0;
        int currentCol = cols - 1;

        // Repeat the search until it goes off the grid.
        while (currentRow < rows && currentCol >= 0) {
            if (binaryMatrix.get(currentRow, currentCol) == 0) {
                currentRow++;
            } else {
                currentCol--;
            }
        }

        // If we never left the last column, this is because it was all 0's.
        return (currentCol == cols - 1) ? -1 : currentCol + 1;
    }

    // Dummy code. Would not run.
    public static void main(String[] args) {
        Q1428_Leftmost_Column_with_at_Least_a_One sol = new Q1428_Leftmost_Column_with_at_Least_a_One();

        BinaryMatrix binaryMatrix = null;

        int result = sol.leftMostColumnWithOne(binaryMatrix);
        System.out.println(result);
    }

    private class BinaryMatrix {
        public Map<Integer, Integer> dimensions() {
            return null;
        }

        public int get(int currentRow, int currentCol) {
            return 0;
        }
    }
}
