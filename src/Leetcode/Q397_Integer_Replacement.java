package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q397_Integer_Replacement {
    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            count++;
            //Even
            if ((n & 1) == 0) {
                n >>>= 1; // n = n/2
            }
            //Odd number + Last 2 bits are 1
            else if (n == 3 || ((n >>> 1) & 1) == 0) {
                n = n-1;
            } else {
                n = n+1;
            }

        }
        return count;
    }
}
