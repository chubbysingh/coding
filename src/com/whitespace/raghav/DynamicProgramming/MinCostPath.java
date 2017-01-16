package com.whitespace.raghav.DynamicProgramming;

/**
 * Created by rbhatnagar2 on 9/9/15.
 */
public class MinCostPath {

    private static int minCost(int[][] path) {
        if (path == null)
            return 0;

        int m = path.length;
        int n = path[0].length;
        int[][] cost = new int[m][n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    cost[i][j] = path[i][j];
                } else if (i == 0) {
                    cost[i][j] = path[i][j] + cost[i][j - 1];
                } else if (j == 0) {
                    cost[i][j] = path[i][j] + cost[i - 1][j];
                } else {
                    cost[i][j] = path[i][j] +  min(cost[i-1][j-1], min(cost[i - 1][j], cost[i][j - 1]))  ;
                }


            }
        }
        return cost[m-1][n-1];
    }

    private static int min(int x, int y) {
        return x < y ? x : y;
    }

    public static void main(String[] args) {
        int path[][] = {
                {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}
        };
        System.out.println(minCost(path));

    }

}
