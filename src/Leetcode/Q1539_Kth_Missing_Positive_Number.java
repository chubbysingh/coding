package Leetcode;

/**
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * Find the kth positive integer that is missing from this array.
 *
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 *
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 *
 */
public class Q1539_Kth_Missing_Positive_Number {

    public int findKthPositive(int[] A, int k) {
        int left = 0, right = A.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (A[mid] - 1 - mid < k)
                left = mid + 1;
            else
                right = mid;
        }
        return left + k;
    }

    public static void main(String[] args) {
        Q1539_Kth_Missing_Positive_Number sol = new Q1539_Kth_Missing_Positive_Number();

        int[] A = {2, 3, 4, 7, 11};
        int k = 5;

        int result = sol.findKthPositive(A, k);
        System.out.println(result);
    }
}
