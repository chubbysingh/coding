package com.whitespace.raghav.DynamicProgramming;

/**
 * Created by rbhatnagar2 on 9/13/15.
 */
public class Knapsack01 {
    private static int knapsack(int[] wt, int[] value, int weight) {
        int cols = weight + 1;
        int rows = wt.length + 1;

        int[][] table = new int[rows][cols];

        for (int i=0; i< rows; i++) {
            for (int j=0; j < cols; j++) {
                if (i==0 || j==0) {
                    table[i][j] = 0;
                    continue;
                }

                if (j - wt[i-1] > 0) {
                    int x = table[i-1][j - wt[i-1]] + value[i-1];
                    int y = table[i-1][j];
                    table[i][j] = max(x, y);
                } else {
                    table[i][j] = table[i-1][j];
                }
            }
        }

        return table[rows-1][cols-1];
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] value = {1, 4, 5, 7};
        int weight = 7;

        int maxValue = knapsack(wt, value, weight);
        System.out.println("Max weight : " + maxValue);
    }
}
