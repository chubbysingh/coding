package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 *
 */
public class Q200_Number_of_Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int count = 0;
        int rows = grid.length,
                cols = grid[0].length;

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }

            }
        }
        return count;
    }

    private void helper(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1')
            return;

        grid[row][col] = '0';
        helper(grid, row+1, col);
        helper(grid, row-1, col);
        helper(grid, row, col+1);
        helper(grid, row, col-1);
    }
}
