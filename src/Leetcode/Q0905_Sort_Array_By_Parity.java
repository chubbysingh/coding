package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array nums of non-negative integers,
 * return an array consisting of all the even elements of nums,
 * followed by all the odd elements of nums.
 *
 */
public class Q0905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;

        while (i < j) {
            if (isOdd(A[i]) && isEven(A[j])) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (isEven(A[i])) i++;
            if (isOdd(A[j]) ) j--;
        }

        return A;
    }

    private boolean isEven(int a) {
        return a % 2 == 0;
    }

    private boolean isOdd(int a) {
        return a % 2 != 0;
    }

    public static void main(String[] args) {
        Q0905_Sort_Array_By_Parity sol = new Q0905_Sort_Array_By_Parity();
        int[] nums = {3, 1, 2, 4};

        System.out.println(sol.sortArrayByParity(nums));

    }
}
