package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q413_Arithmetic_Slices {
    public int numberOfArithmeticSlices(int[] A) {
        int cur = 0, sum = 0;

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] - A[i - 1] == A[i + 1] - A[i]) {
                cur += 1;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}
