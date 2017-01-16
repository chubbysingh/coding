package com.whitespace.raghav.DynamicProgramming;

import java.math.BigInteger;

/**
 * Created by rbhatnagar2 on 9/9/15.
 */
public class CoinChange {

    /**
     *
     * Amount = 4
     * Coins = {1, 2, 3}
     *
     * # of ways : {1,1,1,1}, {1, 1, 2}, {2, 2}, {1, 3}
     *
     *
     */

    private static BigInteger waysCoins(int[] coins, Integer amount) {
        if (amount == null || coins == null) {
            return BigInteger.ZERO;
        }

        int cols = amount+1;
        int rows = coins.length+1;

        BigInteger[][] table = new BigInteger[rows][cols];

        for (int i=0; i < rows; i++) {
            table[i][0] = BigInteger.ONE;
        }

        for (int j=1; j < cols; j++) {
            table[0][j] = BigInteger.ZERO;
        }

        for (int i=1; i < rows; i++) {
            for (int j=1; j < cols; j++) {
                BigInteger x = j - coins[i-1] >= 0 ? table[i][j-coins[i-1]] : BigInteger.ZERO;
                BigInteger y = table[i-1][j];
                table[i][j] = x.add(y);
            }
        }


        return table[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[] coins = {2, 3, 5, 6};
        int amount = 10;
        System.out.println(waysCoins(coins, amount));
    }
}
