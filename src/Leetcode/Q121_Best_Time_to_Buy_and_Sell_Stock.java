package Leetcode;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 */
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int minSoFar = prices[0];
        int profit = 0;

        for (int price : prices) {
            if (price < minSoFar) {
                minSoFar = price;
            } else {
                profit = Math.max(profit, price - minSoFar);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Q121_Best_Time_to_Buy_and_Sell_Stock sol = new Q121_Best_Time_to_Buy_and_Sell_Stock();

        int[] prices = {7,1,5,3,6,4};

        int result = sol.maxProfit(prices);
        System.out.println(result);
    }
}
