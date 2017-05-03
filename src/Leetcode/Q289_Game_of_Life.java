package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q289_Game_of_Life {
    public void gameOfLife(int[][] board) {
        if (board == null)
            return;

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeibours = getLiveNeibours(i, j, board);

                //live to dead = 2
                //dead to live = 3
                if (board[i][j] == 1) {
                    if (liveNeibours < 2 || liveNeibours > 3)
                        board[i][j] = 2;
                } else {
                    if (liveNeibours == 3)
                        board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 0;
                if (board[i][j] == 3)
                    board[i][j] = 1;
            }
        }
    }

    // Check live + those who were live
    private int getLiveNeibours(int i, int j, int[][] board) {
        int result = 0;
        int rows = board.length;
        int cols = board[0].length;

        //up
        if (i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == 2))
            result += 1;

        //down
        if (i + 1 < rows && (board[i + 1][j] == 1 || board[i + 1][j] == 2))
            result += 1;

        //left
        if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 2))
            result += 1;

        //right
        if (j + 1 < cols && (board[i][j + 1] == 1 || board[i][j + 1] == 2))
            result += 1;

        //up-right
        if (i - 1 >= 0 && j + 1 < cols && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2))
            result += 1;

        //up-left
        if (i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2))
            result += 1;

        //down-right
        if (i + 1 < rows && j + 1 < cols && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2))
            result += 1;

        //down-left
        if (i + 1 < rows && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2))
            result += 1;

        return result;

    }
}
