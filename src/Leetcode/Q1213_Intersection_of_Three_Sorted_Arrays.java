package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 *
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 *
 */
public class Q1213_Intersection_of_Three_Sorted_Arrays {

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        int l1 = 0, l2 = 0, l3 = 0;

        while (l1 < arr1.length && l2 < arr2.length && l3 < arr3.length) {
            int min = Math.min(arr1[l1], Math.min(arr2[l2], arr3[l3]));

            if (min == arr1[l1] && min == arr2[l2] && min == arr3[l3])
                result.add(min);
            if (min == arr1[l1])
                l1++;
            if (min == arr2[l2])
                l2++;
            if (min == arr3[l3])
                l3++;
        }
        return result;
    }

    public static void main(String[] args) {
        Q1213_Intersection_of_Three_Sorted_Arrays sol = new Q1213_Intersection_of_Three_Sorted_Arrays();

        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,5,7,9};
        int[] arr3 = {1,3,4,5,8};

        List<Integer> result = sol.arraysIntersection(arr1, arr2, arr3);
        System.out.println("Result: " + result);
    }
}
