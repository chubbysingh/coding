package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q122_Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i=0; i<prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                max += prices[i+1] - prices[i];
            }
        }
        return max;
    }
}
