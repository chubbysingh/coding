package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://leetcode.com/problems/powx-n/
 */
public class Q0050_Pow {
    public double myPow(double x, int n) {
        // Not required. Only for leetcode crappy edge case
        if (n == Integer.MIN_VALUE) {
            x = x*x;
            n = n/2;
            return myPow(x, n);
        }
        if (n < 0)
            return myPow(1/x, -n);

        else if (n == 0)
            return 1;

        else if (n == 1)
            return x;

        else if (n % 2 == 0) {
            return myPow(x * x, n / 2);
        } else {
            return x * myPow(x * x, n / 2);
        }
    }
}
