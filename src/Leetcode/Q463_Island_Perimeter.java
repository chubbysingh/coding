package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q463_Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                }
                if (grid[i + 1][j] == 1) {
                    perimeter -= 1;
                }
                if (grid[i - 1][j] == 1) {
                    perimeter -= 1;
                }
                if (grid[i][j + 1] == 1) {
                    perimeter -= 1;
                }
                if (grid[i][j - 1] == 1) {
                    perimeter -= 1;
                }
            }
        }
        return perimeter;
    }
}
