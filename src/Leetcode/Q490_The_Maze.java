package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 * <p>
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 * <p>
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 * <p>
 * Example 1
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
 * <p>
 * Output: true
 * Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
 * <p>
 * Example 2
 * <p>
 * Input 1: a maze represented by a 2D array
 * <p>
 * 0 0 1 0 0
 * 0 0 0 0 0
 * 0 0 0 1 0
 * 1 1 0 1 1
 * 0 0 0 0 0
 * <p>
 * Input 2: start coordinate (rowStart, colStart) = (0, 4)
 * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
 * <p>
 * Output: false
 * Explanation: There is no way for the ball to stop at the destination.
 */

public class Q490_The_Maze {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private boolean isok(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && (maze[x][y] & 1) == 0;
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (Arrays.equals(start, destination)) return true;
        int x = start[0], y = start[1];
        if ((maze[x][y] & 2) != 0) return false; // if visited then no solution
        maze[x][y] |= 2;

        for (int k = 0; k < dx.length; k++) {
            int xx = x + dx[k], yy = y + dy[k];
            while (isok(maze, xx, yy)) {
                xx += dx[k];
                yy += dy[k];
            }
            xx -= dx[k];
            yy -= dy[k];
            if ((xx != x || yy != y) && hasPath(maze, new int[]{xx, yy}, destination)) return true;
        }
        return false;
    }
}
