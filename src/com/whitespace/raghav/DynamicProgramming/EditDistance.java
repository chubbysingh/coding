package com.whitespace.raghav.DynamicProgramming;

/**
 * Created by rbhatnagar2 on 9/9/15.
 */
public class EditDistance {
    private static int distance(String s1, String s2) {
        if (s1 == null || s2 == null)
            return 0;

        int s1Length = s1.length(), s2Length = s2.length();
        int[][] table = new int[s1Length+1][s2Length+1];

        for (int i=0 ; i <= s1Length; i++) {
            for (int j=0; j<= s2Length; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = i == 0 ? j : i;
                }
                else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    table[i][j] = table[i-1][j-1];
                } else {
                    table[i][j] = min(table[i-1][j], table[i-1][j-1], table[i][j-1]) + 1;
                }
            }
        }
        return table[s1Length][s2Length];
    }

    private static int min(int x, int y, int z) {
        return x > y ? (y > z ? z : y) : (x > z ? z : x);
    }
    public static void main(String[] args) {
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";
        System.out.println(distance(s1, s2));
    }

}
