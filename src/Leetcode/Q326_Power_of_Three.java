package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q326_Power_of_Three {
    public boolean isPowerOfThree(int n) {
        if(n == 0)
            return false;
        if (n == 1)
            return true;
        if (n%3 == 0)
            return isPowerOfThree(n/3);
        else
            return false;
    }
}
