package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q069_Sqrt_x {
    public int mySqrt(int x) {

        if (x <= 0)
            return 0;

        else if (x < 1)
            return 1 / mySqrt(1 / x);

        else if (x == 1)
            return 1;

        int left = 1, right = x / 2 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int sq = mid * mid;
            if (sq == x) {
                return mid;
            } else if (sq > x) {
                right = mid;
            } else {
                if (mid + 1 > (x / (mid + 1))) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return -1;
    }

    public int mySqrtMethodTwo(int x) {

        if (x == 0) {
            return 0;
        }

        if (x < 0) {
            return -1;
        }

        long lo = 0;
        long hi = x / 2 + 1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long sq = mid * mid;
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

    public double sqrt(double num) {
        if (num < 0)
            return -1;
        if (num == 0)
            return 0;
        if (num < 1)
            return 1 / sqrt(1/num);

        double lo = 0, hi = num;
        double precision = 0.00000000000001;

        while(true) {
            double mid = lo + (hi-lo)/2;

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
