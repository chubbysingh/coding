package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0029_Divide_Two_Integers {

    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        dividend = Math.abs( dividend);
        divisor = Math.abs( divisor);

        //Take care the edge cases.
        if (divisor == 0) return Integer.MAX_VALUE;

        //Not needed. Code can handle these two conditions.
        if (divisor == 1) return sign*dividend;
        if ((dividend == 0) || (dividend < divisor)) return 0;

        int ans = divideHelper(dividend, divisor);

        return ans * sign;
    }

    private int divideHelper(int dividend, int divisor) {
        // Recursion exit condition
        if (dividend < divisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        int sum = divisor;
        int multiple = 1;
        while ((sum + sum) <= dividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + divideHelper(dividend - sum, divisor);
    }

    /*
    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1)
            return Integer.MAX_VALUE;

        //Reduce the problem to positive long integer to make it easier.
        //Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        int ldividend = Math.abs( dividend);
        int ldivisor = Math.abs( divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if (ldivisor == 1) return sign*dividend;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;

        int lans = ldivide(ldividend, ldivisor);

        int ans;
        if (lans > Integer.MAX_VALUE) { //Handle overflow.
            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private int ldivide(int ldividend, int ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        int sum = ldivisor;
        int multiple = 1;
        while ((sum + sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
    */

    public static void main(String[] args) {
        Q0029_Divide_Two_Integers sol = new Q0029_Divide_Two_Integers();
        int res = sol.divide(-1, 1);
        System.out.println(res);
    }
}
