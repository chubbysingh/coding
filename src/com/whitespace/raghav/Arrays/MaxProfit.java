package com.whitespace.raghav.Arrays;

/**
 * Maximum profit by buying and selling a share at most twice
 */
public class MaxProfit {
    private static int maxProfit(int[] price) {
        if (price == null || price.length == 0)
            return 0;

        int n = price.length;
        int[] profit = new int[n];

        // initialize the elements to 0
        for (int i=0; i<n; i++) {
            profit[i] = 0;
        }

        int maxPrice = price[n-1];
        for (int i = n-2; n >= 0; i--) {

            if (maxPrice < price[i]) {
                maxPrice = price[i];
            }

            profit[i] = max(profit[i+1], maxPrice - price[i]);
        }

        int minPrice = price[0];
        for (int i=2; i<n-1; i++) {
            if (minPrice > price[i]) {
                minPrice = price[i];
            }
            profit[i] = max(profit[i-1], profit[i] + price[i] - minPrice);
        }

        return profit[n-1];

    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 5, 75, 65, 80};
        int maxProfit = maxProfit(arr);
        System.out.println("Max profit : " + maxProfit);
    }
}
