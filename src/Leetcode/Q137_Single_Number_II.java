package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q137_Single_Number_II {

    public int singleNumberEasy(int[] A) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;

            int index = 1 << i;

            for (int num : A) {
                if ((num & index) != 0)
                    sum++;
            }

            if (sum % 3 != 0) {
                result |= index;
            }
        }
        return result;
    }

    public int singleNumber(int[] A) {
        int ones = 0, twos = 0, threes = 0;
        for (int i = 0; i < A.length; i++) {
            twos |= ones & A[i];
            ones ^= A[i];
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
