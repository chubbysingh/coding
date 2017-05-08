package com.whitespace.raghav.DynamicProgramming;

/**
 * Created by rbhatnagar2 on 9/9/15.
 */
public class LongestIncreasingSubsequence {
    private static int lis(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int[] count = new int[arr.length];
        for (int i = 0; i < count.length; i++) {
            count[i] = 1;
        }

        for (int i = 1; i < count.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    count[i] = max(count[i], count[j] + 1);
                }
            }
        }


        return getMax(count);
    }

    private static int getMax(int[] count) {
        int max = Integer.MIN_VALUE;
        for (int i : count) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(lis(arr));
    }
}
