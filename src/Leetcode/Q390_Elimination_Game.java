package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q390_Elimination_Game {
    public int lastRemaining(int n) {
        return f(n,true);
    }

    public int f(int n,boolean flag){
        if (n<=2) {
            return flag?n:1;
        }else{
            return 2*f(n/2,!flag)-(((n&1)==0&&!flag)?1:0);
        }
    }
}
