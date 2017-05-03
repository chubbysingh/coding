package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q441_Arranging_Coins {
    public int arrangeCoins(int n) {
        // x (x+1) / 2 = n

        // x = (-1 + (1 + 4n)^1/2 ) / 2;

        return (int) (-1 + Math.sqrt(1 + 8.0 * n)) / 2;
    }
}
