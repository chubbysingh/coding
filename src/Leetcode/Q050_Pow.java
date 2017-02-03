package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q050_Pow {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            if (x < 0) {
                x = -x;
            }
            n++;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        }
        if (n == 0) {
            return 1;
        }
        else if (n == 1) {
            return x;
        }

        else if (n%2 == 0) {
            double part = myPow(x, n/2);
            return part*part;
        } else {
            double part = myPow(x, n/2);
            return x * part * part;
        }
    }
}
