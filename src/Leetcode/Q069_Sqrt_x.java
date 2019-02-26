package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Q069_Sqrt_x {

    public int sqrt(int x) {
        if (x < 0)
            return -1;
        if (x == 0)
            return 0;

        double lo = 0,
               hi = x;

        while (lo <= hi) {
            double mid = lo + (hi - lo) / 2;
            double sq = mid * mid;
            if (sq == x) {
                return (int) mid;
            }

            if (sq < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return (int) hi;
    }

    /**
     * Sqrt with precision
     * @param num
     * @return
     */
    public double sqrt(double num) {
        if (num < 0)
            return -1;
        if (num == 0)
            return 0;
        if (num < 1)
            return 1 / sqrt(1/num);

        double lo = 0,
               hi = num;

        double precision = 0.00000000000001;

        while(true) {
            double mid = lo + (hi-lo) / 2;

            double currPrec = Math.abs(mid*mid - num);
            if (currPrec < precision)
                return mid;
            else if (mid*mid < num)
                lo = mid+1;
            else
                hi = mid-1;
        }
    }

    public static void main(String[] args) {
        Q069_Sqrt_x sol = new Q069_Sqrt_x();
        double num = 3.0;
        double ans = sol.sqrt(num);
        System.out.println(ans);
    }
}
