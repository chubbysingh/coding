package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Gives StackOverflow error on leetcode OJ
 *
 */
public class Q130_Surrounded_Regions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // check the first and last rows
        for (int i = 0; i < n; i++) {
            solveHelper(0, i, m, n, board);
            solveHelper(m - 1, i, m, n, board);
        }

        // check the first and last column
        for (int i = 1; i < m - 1; i++) {
            solveHelper(i, 0, m, n, board);
            solveHelper(i, n - 1, m, n, board);
        }

        // fill
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void solveHelper(int row, int col, int m, int n, char[][] board) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
            return;
        }

        board[row][col] = 'D';

        solveHelper(row - 1, col, m, n, board);
        solveHelper(row + 1, col, m, n, board);
        solveHelper(row, col - 1, m, n, board);
        solveHelper(row, col + 1, m, n, board);

    }
}
