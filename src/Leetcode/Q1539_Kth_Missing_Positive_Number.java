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

    // https://www.youtube.com/watch?v=88k8xa-pSrM&t=270s
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right-left)/2;
            int numberOfElementsMissing =
                    computeNumberOfElementsMissing(arr,  mid);

            if(numberOfElementsMissing >= k) {
                // answer lies in left part
                right = mid-1;
            }
            else {
                // answer lies in right part
                left = mid+1;
            }
        }

        // Special case if all elements are missing from start of the array
        // e.g. num = [4, 5, 6, 7, 8] ; k = 2
        if(right == -1)
            return k;
        return arr[right] + k - computeNumberOfElementsMissing(arr, right);
    }

    int computeNumberOfElementsMissing(int[] arr, int index) {
        return arr[index] - index - 1;
    }

    public int findKthPositiveSimplified(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] -  mid - 1 < k) {
                lo = mid + 1; // answer lies in left part
            }
            else {
                hi = mid - 1; // answer lies in right part
            }
        }

        //return arr[hi] + k - (arr[hi] - hi - 1);
        return k + hi + 1;
    }

    public int findKthPositiveAlternate(int[] A, int k) {
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

        int[] A = {2, 3, 4, 9, 11};
        int k = 5;

        int result = sol.findKthPositive(A, k);
        System.out.println(result);
    }
}
