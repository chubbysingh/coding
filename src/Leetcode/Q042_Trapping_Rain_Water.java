package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * The trapped water for slot i is determined by
 * min(leftMostHeight[i], rgithMostHeight[i]) - A[i],
 * which means the most water trapped for
 * slot i is determined by
 * the highest block left to i (exclusive),
 * and the highest block right to i, whichever is less,
 * and subtract by the height of the block itself.
 */
public class Q042_Trapping_Rain_Water {
    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }

        int[] maxLeft = new int[A.length];
        int[] maxRight = new int[A.length];
        int max = 0;
        int sum = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] > max) {
                max = A[i - 1];
            }
            maxLeft[i] = max;
        }

        max = 0;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i + 1] > max) {
                max = A[i + 1];
            }
            maxRight[i] = max;
        }

        for (int i = 0; i < A.length; i++) {
            int water = Math.min(maxLeft[i], maxRight[i]) - A[i];
            if (water > 0) {
                sum += water;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Q042_Trapping_Rain_Water sol = new Q042_Trapping_Rain_Water();
        int[] A = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int sum = sol.trap(A);
        System.out.println(sum);
    }
}
