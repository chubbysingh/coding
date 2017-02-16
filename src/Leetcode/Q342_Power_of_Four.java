package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q342_Power_of_Four {

    // Square + 3n+1 form
    public boolean isPowerOfFour(int num) {
        return ( ( (num & (num-1)) == 0) && ( (num-1) % 3 == 0) ) ;
    }

    public boolean isPowerOfFourSimple(int num) {
        if (num < 1)
            return false;
        while (num > 1) {
            if (num%4 == 0)
                num /= 4;
            else
                return false;
        }
        return true;
    }

    public boolean isPowerOfFourMaths(int num) {
        return num > 0
                && num == Math.pow(4, Math.round(Math.log(num) / Math.log(4)));
    }
}
