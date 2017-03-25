package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q037_Sudoku_Solver {
    public void solveSudoku(char[][] board) {
        boolean[][] flag=new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                flag[i][j]=board[i][j]=='.';
            }
        }
        for (int i = 0; i < 81;) {
            int x=i/9;
            int y=i%9;
            if (flag[x][y]) {
                if (board[x][y]=='.') {
                    board[x][y]='1';
                    if (f(board,x,y,board[x][y])) {
                        i++;
                    }
                }else if(board[x][y]<'9'){
                    board[x][y]++;
                    if (f(board,x,y,board[x][y])) {
                        i++;
                    }
                }else {
                    while ((!flag[x][y])||board[x][y]=='9') {
                        if (flag[x][y]) {
                            board[x][y]='.';
                        }
                        i--;
                        if (i<0) {
                            return ;
                        }
                        x=i/9;
                        y=i%9;
                    }
                }
            }else {
                i++;
            }
        }
    }
    public boolean f(char[][] board,int x,int y,char val){
        int a=x/3;
        int b=y/3;
        for (int i = 0; i < 9; i++) {
            if (i!=y) {
                if (board[x][i]==val) {
                    return false;
                }
            }
            if (x!=i) {
                if (board[i][y]==val) {
                    return false;
                }
            }
            int ax=i/3;
            int by=i%3;
            if (x!=a*3+ax||y!=b*3+by) {
                if (board[a*3+ax][b*3+by]==val) {
                    return false;
                }
            }
        }
        return true;
    }
}
