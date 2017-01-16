package com.whitespace.raghav.DynamicProgramming;

/**
 * Created by rbhatnagar2 on 9/9/15.
 */
public class LongestCommonSubstring {
    private static int lcs(String s1, String s2) {
        if (s1 == null || s2 == null)
            return 0;
        if (s1.length() ==0 || s2.length() == 2)
            return 0;

        int s1Length = s1.length(), s2Length = s2.length();

        int[][] table = new int[s1Length+1][s2Length+1];

        for (int i=0; i<table.length; i++) {
            table[i][0] = 0;
        }
        for (int j=0; j<table[0].length; j++) {
            table[0][j] = 0;
        }

        for (int i=1; i<table.length; i++) {
            for (int j=1; j< table[0].length; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    table[i][j] = table[i-1][j-1] + 1;
                } else {
                    table[i][j] = max(table[i-1][j], table[i][j-1]);
                }
            }
        }
        return table[s1Length][s2Length];
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcs(s1, s2));
    }
}
