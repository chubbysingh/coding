package Leetcode;

import java.util.LinkedList;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Design a Snake game that is played on a device with screen size = width x height.
 * Play the game online if you are not familiar with the game.
 * <p>
 * The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
 * <p>
 * You are given a list of food's positions in row-column order.
 * When a snake eats the food, its length and the game's score both increase by 1.
 * <p>
 * Each food appears one by one on the screen.
 * For example, the second food will not appear until the first food was eaten by the snake.
 * <p>
 * When a food does appear on the screen,
 * it is guaranteed that it will not appear on a block occupied by the snake.
 */
public class Q353_Design_Snake_Game {
    int[][] food;
    int index;
    int row, col;
    int x, y;
    int len;
    LinkedList<int[]> queue;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public Q353_Design_Snake_Game(int width, int height, int[][] food) {
        this.food = food;
        this.index = 0;
        this.x = 0;
        this.y = 0;
        this.row = height;
        this.col = width;
        this.queue = new LinkedList<int[]>();
        this.queue.offer(new int[]{0, 0});
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        switch (direction) {
            case "U":
                x--;
                break;
            case "L":
                y--;
                break;
            case "R":
                y++;
                break;
            case "D":
                x++;
                break;
        }

        if (!isValid(x, y)) {
            return -1;
        }

        return process(x, y);
    }

    public boolean isValid(int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col)
            return false;

        return true;
    }

    public int process(int x, int y) {

        if (index == food.length) {
            queue.poll();

        } else if (food[index][0] == x && food[index][1] == y) {
            len++;
            index++;
        } else {
            queue.poll();
        }

        for (int[] p : queue) {
            if (p[0] == x && p[1] == y)
                return -1;
        }

        queue.offer(new int[]{x, y});

        return len;
    }
}
