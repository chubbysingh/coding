package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0036_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9)
            return false;

        return validateRowAndCols(board) && validateCube(board);
    }

    private boolean validateRowAndCols(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowSet.contains(board[i][j]))
                        return false;
                    else
                        rowSet.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (colSet.contains(board[j][i]))
                        return false;
                    else
                        colSet.add(board[j][i]);
                }
            }
        }
        return true;
    }

    private boolean validateCube(char[][] board) {

        for (int bucket = 0; bucket < 9; bucket++) {
            Set<Character> set = new HashSet<>();
            for (int i = bucket / 3 * 3; i < bucket / 3 * 3 + 3; i++) {
                for (int j = bucket % 3 * 3; j < bucket % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (set.contains(board[i][j]))
                            return false;
                        else
                            set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q0036_Valid_Sudoku sol = new Q0036_Valid_Sudoku();
        char[][] input = {{'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };

        boolean isValid = sol.isValidSudoku(input);
        System.out.println(isValid);
    }
}
