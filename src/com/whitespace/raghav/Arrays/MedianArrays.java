package com.whitespace.raghav.Arrays;

/**
 * Created by rbhatnagar2 on 9/19/15.
 */
public class MedianArrays {
    public static int median(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null)
            return -1;

        if (arr1 == null || arr2 == null)
            return -1;

        int start_a = 0, start_b = 0, end_a = arr1.length - 1, end_b = arr2.length - 1;

        return medianRecursive(arr1, arr2, start_a, end_a, start_b, end_b);
    }

    private static int medianRecursive(int[] arr1, int[] arr2, int start_a, int end_a, int start_b, int end_b) {
        if (arr1.length == 1 && arr2.length == 1)
            return (arr1[start_a] + arr2[start_b]) / 2;

        if (arr1.length == 1 && arr2.length == 1) {
            return max(arr1[start_a], arr2[start_b]) + min(arr1[end_a], arr2[end_b]) / 2;
        } else {
            int m1_index = (end_a - start_a) / 2;
            int m2_index = (end_b - start_b) / 2;

            int m1 = arr1[m1_index];
            int m2 = arr2[m2_index];

            if (m1 == m2) {
                return m1;
            } else if (m1 > m2) {
                end_a = m1_index;
                start_b = m2_index;
            } else {
                start_a = m1_index;
                end_b = m2_index;
            }
            medianRecursive(arr1, arr2, start_a, end_a, start_b, end_b);
        }
        return -1;
    }

    private static int min(int x, int y) {
        return x > y ? y : x;
    }

    private static int max(int x, int y) {
        return x > y ? x : y;
    }
}
