package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 */
public class Q069_Sqrt_x {

    public int sqrt(int x) {
        if (x == 0)
            return 0;

        int left = 1, //to avoid NPE
            right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid == x/mid)
                return mid;

            else if (mid <= x / mid)
                left = mid + 1;

            else
                right = mid - 1;
        }
        return right;
    }

    /**
     * Sqrt with precision
     * @param num
     * @return
     */
    public double sqrt(double num) {
        if (num < 0) return -1;

        if (num == 0) return 0;

        if (num < 1) return 1 / sqrt(1/num);

        double lo = 1,
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
