package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given num, the array-form of an integer, and an integer k,
 * return the array-form of the integer num + k.
 *
 */
public class Q0989_Add_to_Array_Form_of_Integer {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new LinkedList<>();

        for (int i = A.length - 1; i>=0; i--) {
            int digit = A[i] + K;

            result.add(0, digit%10);
            K = digit/10;
        }

        while (K > 0) {
            result.add(0, K%10);
            K /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Q0989_Add_to_Array_Form_of_Integer sol = new Q0989_Add_to_Array_Form_of_Integer();
        int[] nums = {1, 2, 0, 0};

        List<Integer> result = sol.addToArrayForm(nums, 34);
        System.out.println(result);

    }
}
