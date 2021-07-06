package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 *
 * Return the size of the largest island in grid after applying this operation.
 *
 * An island is a 4-directionally connected group of 1s.
 */
public class Q0827_Making_A_Large_Island {
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int colorIndex = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int sum = paint(grid, i, j, colorIndex);
                    map.put(colorIndex, sum);
                    colorIndex++;
                }
            }
        }

        //If there is no island 0 from grid, res should be the size of islands of first color
        //If there is no island 1 from grid, res should be 0
        int result = map.getOrDefault(2, 1);

        //Calculate the largestIsland
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();

                    if (i > 0) set.add(grid[i-1][j]);
                    if (j > 0) set.add(grid[i][j-1]);
                    if (i + 1 < grid.length) set.add(grid[i+1][j]);
                    if (j + 1 < grid[0].length) set.add(grid[i][j+1]);

                    int increasedSizeOfIsland = 1;
                    for (int color : set) {
                        increasedSizeOfIsland += map.get(color);
                    }

                    result = Math.max(result, increasedSizeOfIsland);
                }
            }
        }
        return result;
    }

    //Helper method to paint current island and all its connected neighbors
    //Return the size of all painted islands at the end
    private int paint(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return 0;

        grid[i][j] = color;

        return 1 + paint(grid, i + 1, j, color)
                + paint(grid, i - 1, j, color)
                + paint(grid, i, j + 1, color)
                + paint(grid, i, j - 1, color);
    }

    public static void main(String[] args) {
        Q0827_Making_A_Large_Island sol = new Q0827_Making_A_Large_Island();

        int[][] grid = {{1,1}, {1, 1}};

        int result = sol.largestIsland(grid);
        System.out.println(result);
    }
}
