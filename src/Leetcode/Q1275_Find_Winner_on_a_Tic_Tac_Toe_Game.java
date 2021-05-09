package Leetcode;

/**
 * Return the winner of the game if it exists (A or B),
 * in case the game ends in a draw return "Draw",
 * if there are still movements to play return "Pending".
 *
 */
public class Q1275_Find_Winner_on_a_Tic_Tac_Toe_Game {

    private char[][] grid = new char[3][3];

    public String tictactoe(int[][] moves) {

        for (int i = 0; i < moves.length; i++) {

            char player;
            if (i % 2 == 0) {
                player = 'A';
            } else {
                player = 'B';
            }

            grid[moves[i][0]][moves[i][1]] = player;
        }

        if(win('A')) return "A";
        if(win('B')) return "B";
        if(moves.length == 9) return "Draw";
        return "Pending";
    }

    private boolean win(Character c) {
        for(int i = 0; i < 3; i++){

            if(grid[i][0] == c && grid[i][1] == c && grid[i][2] == c )
                return true;

            if(grid[0][i] == c && grid[1][i] == c && grid[2][i] == c )
                return true;
        }

        if (grid[0][0] == c && grid[1][1] == c && grid[2][2] == c) {
            return true;
        }

        if(grid[2][0] == c && grid[1][1] == c && grid[0][2] == c )
            return true;

        return false;

    }

    public static void main(String[] args) {
        Q1275_Find_Winner_on_a_Tic_Tac_Toe_Game sol = new Q1275_Find_Winner_on_a_Tic_Tac_Toe_Game();

        int[][] moves = {{0,0}, {2,0}, {1,1}, {2,1}, {2,2}};

        String result = sol.tictactoe(moves);
        System.out.println(result);
    }
}
