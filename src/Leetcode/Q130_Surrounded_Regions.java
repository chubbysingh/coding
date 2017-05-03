package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * <p>
 * Gives StackOverflow error on leetcode OJ
 */
public class Q130_Surrounded_Regions {

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        // check the first and last rows & backtrack
        for (int i = 0; i < n; i++) {
            solveHelper(0, i, m, n, board);
            solveHelper(m - 1, i, m, n, board);
        }

        // check the first and last column & backtrack
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
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }

        if (board[row][col] != 'O')
            return;

        board[row][col] = 'D';

        solveHelper(row - 1, col, m, n, board);
        solveHelper(row + 1, col, m, n, board);
        solveHelper(row, col - 1, m, n, board);
        solveHelper(row, col + 1, m, n, board);

    }

    public static void main(String[] args) {
        Q130_Surrounded_Regions sol = new Q130_Surrounded_Regions();

        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        sol.solve(board);
        System.out.println(board);


    }






    /*



    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0)
            return;

        int m=board.length;
        int n=board[0].length;


        for(int j=0; j<n; j++){
            if(board[0][j]=='O'){
                bfs(board, 0, j);
            }
        }

        for(int j=0; j<n; j++){
            if(board[m-1][j]=='O'){
                bfs(board, m-1, j);
            }
        }

        for(int i=0; i<m; i++){
            if(board[i][0]=='O'){
                bfs(board, i, 0);
            }
        }

        for(int i=0; i<m; i++){
            if(board[i][n-1]=='O'){
                bfs(board, i, n-1);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='1'){
                    board[i][j]='O';
                }
            }
        }
    }

    public void bfs(char[][] board, int o, int p){
        int m=board.length;
        int n=board[0].length;

        int index = o*n+p;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        board[o][p]='1';

        while(!queue.isEmpty()){
            int top = queue.poll();
            int i=top/n;
            int j=top%n;

            if(i-1>=0 && board[i-1][j]=='O'){
                board[i-1][j]='1';
                queue.offer((i-1)*n+j);
            }
            if(i+1<m && board[i+1][j]=='O'){
                board[i+1][j]='1';
                queue.offer((i+1)*n+j);
            }
            if(j-1>=0 && board[i][j-1]=='O'){
                board[i][j-1]='1';
                queue.offer(i*n+j-1);
            }
            if(j+1<n && board[i][j+1]=='O'){
                board[i][j+1]='1';
                queue.offer(i*n+j+1);
            }
        }
    }

    */
}
