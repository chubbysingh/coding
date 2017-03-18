package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 */
public class Q079_Word_Search {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            return true;
        if (board.length == 0 && board[0].length == 0 && word.length() == 0)
            return true;

        int rows = board.length,
                cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                boolean result = existHelper(board, word, 0 /*start*/, i, j, visited);
                if(result)
                    return result;
            }
        }
        return false;
    }

    private boolean existHelper(char[][] board, String word, int start, int row, int col, boolean[][] visited) {
        //Reached the End
        if (start == word.length())
            return true;
        //Reached out of boundry
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return false;
        //Already visited
        if (visited[row][col])
            return false;
        //Character is not the same
        if (word.charAt(start) != board[row][col] )
            return false;

        visited[row][col] = true;
        // check adjacent
        boolean result = existHelper(board, word, start+1, row+1, col, visited)
                || existHelper(board, word, start+1, row-1, col, visited)
                || existHelper(board, word, start+1, row, col+1, visited)
                || existHelper(board, word, start+1, row, col-1, visited);

        // Clear the boolean for the case when we get a false.
        visited[row][col] = false;

        return result;

    }
}
