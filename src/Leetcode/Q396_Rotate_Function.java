package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q396_Rotate_Function {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length == 0) return 0;
        int oneSum = 0, len = A.length, patternSum = 0;
        for (int i = 0; i < len; i++) {
            oneSum += A[i];
            patternSum += (A[i] * i);
        }
        int max = patternSum;
        for (int i = 0; i < len; i++) {
            patternSum += len * A[i] - oneSum;
            max = Math.max(max, patternSum);
        }
        return max;
    }
}
