package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int b1 = -prices[0];

        int s2 = 0;
        int s1 = 0;

        for (int i = 1; i <= prices.length; i++) {
            // buy[i] = Math.max(buy[i-1], sell[i-2] - price[i-1]);
            int b0 = Math.max(b1, s2 - prices[i - 1]);
            // sell[i] = Math.max(sell[i-1], buy[i-1] + price[i-1]);
            int s0 = Math.max(s1, b1 + prices[i - 1]);

            b1 = b0;
            s2 = s1;
            s1 = s0;
        }

        return s1;
    }
}
