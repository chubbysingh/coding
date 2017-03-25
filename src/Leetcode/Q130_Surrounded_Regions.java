package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Gives StackOverflow error on leetcode OJ
 *
 */
public class Q130_Surrounded_Regions {
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
}
