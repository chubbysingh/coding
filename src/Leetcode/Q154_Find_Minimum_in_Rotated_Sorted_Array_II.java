package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q154_Find_Minimum_in_Rotated_Sorted_Array_II {
    public int findMinRecursive(int[] num) {
        return findMinRecursive(num, 0, num.length - 1);
    }

    public int findMinRecursive(int[] num, int left, int right) {
        // exit condition 1
        if (left == right)
            return num[left];

            // Just one element, exit condition 2
        else if ((right - left) == 1)
            return Math.min(num[left], num[right]);

            // not rotated, exit condition 3
        else if (num[left] < num[right])
            return num[left];

            // skip duplicate, right shift one
        else if (num[right] == num[left])
            return findMinRecursive(num, left + 1, right);

        int middle = left + (right - left) / 2;

        // left is sorted, go right side
        if (num[middle] >= num[left])
            return findMinRecursive(num, middle, right);

            // go left side
        else
            return findMinRecursive(num, left, middle);
    }

    public static void main(String[] args) {
        Q154_Find_Minimum_in_Rotated_Sorted_Array_II sol = new Q154_Find_Minimum_in_Rotated_Sorted_Array_II();
        int min = sol.findMinRecursive(new int[]{3, 3, 1});
    }
}
