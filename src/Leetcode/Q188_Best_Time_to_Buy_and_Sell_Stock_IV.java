package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q188_Best_Time_to_Buy_and_Sell_Stock_IV {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[k+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[k][prices.length-1];
    }

    public int maxProfitSlowSolution(int prices[], int K) {
        if (K == 0 || prices.length == 0) {
            return 0;
        }
        int T[][] = new int[K+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                int maxVal = 0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal, prices[j] - prices[m] + T[i-1][m]);
                }
                T[i][j] = Math.max(T[i][j-1], maxVal);
            }
        }
        return T[K][prices.length - 1];
    }

    public static void main(String[] args) {
        Q188_Best_Time_to_Buy_and_Sell_Stock_IV sol = new Q188_Best_Time_to_Buy_and_Sell_Stock_IV();
        int[] prices = {2, 5, 7, 1, 4, 3, 1, 3};
        int res = sol.maxProfit(2, prices);
        System.out.println(res);
    }
}
