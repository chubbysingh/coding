package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q342_Power_of_Four {
    public boolean isPowerOfFour(int num) {
        return ( ( (num & (num-1)) == 0) && ( (num-1) % 3 == 0) ) ;
    }
}
