package Leetcode;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 *
 * Input: [1,2,2,3]
 * Output: true
 *
 * Input: [6,5,4,4]
 * Output: true
 *
 * Input: [1,3,2]
 * Output: false
 */

public class Q0896_Monotonic_Array {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;

        for(int i = 0; i < A.length-1; i++) {
            if(A[i] > A[i+1]) increasing=false;
            if(A[i] < A[i+1]) decreasing=false;

            // Can short-circuit like this
            /**
            if ( !(increasing || decreasing))
                return false;
            **/
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        Q0896_Monotonic_Array sol = new Q0896_Monotonic_Array();

        int[] A = {1, 3, 2, 2, 3};

        boolean result = sol.isMonotonic(A);
        System.out.println(result);
    }
}
