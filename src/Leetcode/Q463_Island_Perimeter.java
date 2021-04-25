package Leetcode;

/**
 * You are given row x col grid representing a map
 * where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 *
 * Determine the perimeter of the island.
 */
public class Q463_Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                }
                if ((i + 1 < grid.length) && (grid[i + 1][j] == 1)) {
                    perimeter -= 1;
                }
                if ((i - 1 > 0) && (grid[i - 1][j] == 1)) {
                    perimeter -= 1;
                }
                if ((j + 1 < grid[0].length) && (grid[i][j + 1] == 1)) {
                    perimeter -= 1;
                }
                if ((j - 1 > 0) && (grid[i][j - 1] == 1)) {
                    perimeter -= 1;
                }
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        Q463_Island_Perimeter sol = new Q463_Island_Perimeter();

        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};

        int result = sol.islandPerimeter(grid);
        System.out.println(result);

    }
}
