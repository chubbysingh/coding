package Leetcode;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Assume you have an array of length n initialized with all 0's
 * and are given k update operations.
 * <p>
 * Each operation is represented as a triplet:
 * [startIndex, endIndex, inc]
 * which increments each element of subarray
 * A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * <p>
 * Return the modified array after all k operations were executed.
 */

public class Q370_Range_Addition {
    /*
    The idea is to utilize the fact that the array initializes with zero.
    The hint suggests us that we only needs to modify the first and last element of the range.
    In fact, we need to increment the first element in the range
    and decreases the last element + 1 (if it's within the length) by inc.
    Then we sum up all previous results.
    Why does this work? When we sum up the array,
    the increment is passed along to the subsequent elements
    until the last element.
    When we decrement the end + 1 index, we offset the increment
    so no increment is passed along to the next element.
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int start = updates[i][0], end = updates[i][1];
            int inc = updates[i][2];
            result[start] += inc;
            if (end < length - 1) {
                result[end + 1] -= inc;
            }
        }

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] updates = new int[][]{
                {1, 3, 2},
                {2, 4, 3},
                {0, 2, -2}
        };
        Q370_Range_Addition sol = new Q370_Range_Addition();
        int[] res = sol.getModifiedArray(5, updates);
        System.out.println(res);
    }
}
