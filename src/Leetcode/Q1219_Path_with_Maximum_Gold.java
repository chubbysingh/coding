package Leetcode;

/**
 * In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
 *
 * Return the maximum amount of gold you can collect under the conditions:
 *
 * Every time you are located in a cell you will collect all the gold in that cell.
 * From your position you can walk one step to the left, right, up or down.
 * You can't visit the same cell more than once.
 * Never visit a cell with 0 gold.
 * You can start and stop collecting gold from any position in the grid that has some gold.
 *
 * Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
 * Output: 24
 * Explanation:
 * [[0,6,0],
 *  [5,8,7],
 *  [0,9,0]]
 * Path to get the maximum gold, 9 -> 8 -> 7.
 *
 */
public class Q1219_Path_with_Maximum_Gold {

    public int getMaximumGold(int[][] grid) {
        int highestGold = Integer.MIN_VALUE;
        boolean visited[][] = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    dfs(grid,visited, i, j, 0, highestGold);
                }
            }
        }

        return highestGold;
    }

    public void dfs(int[][] grid, boolean visited[][], int i , int j, int csum, int highestGold){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return;

        if(grid[i][j] == 0 || visited[i][j])
            return;

        visited[i][j] = true;
        csum = csum + grid[i][j];
        highestGold = Math.max(highestGold,csum);

        dfs(grid, visited, i+1,j,csum, highestGold);
        dfs(grid, visited, i-1,j,csum, highestGold);
        dfs(grid, visited, i,j+1,csum, highestGold);
        dfs(grid, visited, i,j-1,csum, highestGold);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        Q1219_Path_with_Maximum_Gold sol = new Q1219_Path_with_Maximum_Gold();

        int[][] grid =   { {0,6,0},
                           {5,8,7},
                           {0,9,0}
                          };

        int result = sol.getMaximumGold(grid);
        System.out.println(result);
    }
}
