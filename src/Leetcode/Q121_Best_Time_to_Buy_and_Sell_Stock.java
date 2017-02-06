package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int minSoFar = prices[0];
        int max = 0;

        for (int price : prices) {
            if (price > minSoFar) {
                max = Math.max(max, price - minSoFar);
            } else {
                minSoFar = price;
            }
        }
        return max;
    }
}
