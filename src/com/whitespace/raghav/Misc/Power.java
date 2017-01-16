package com.whitespace.raghav.Misc;

/**
 * Created by rbhatnagar2 on 10/21/15.
 */
public class Power {
    public double power1(double a, int b) {
        if (a == 0 && b == 0)
            return Integer.MIN_VALUE;
        if (a == 0)
            return 0;
        if (b == 0)
            return 1;
        if (b == 1)
            return a;

        boolean aMinus = a > 0 ? false : true;
        boolean bMinus = b > 0 ? false : true;

        double absA = Math.abs(a);
        int absB = Math.abs(b);

        double tempAnswer ;
        if ((absB % 2) == 0)
            tempAnswer = pow(absA*absA, absB/2);
        else
            tempAnswer = pow(absA, absB-1)*absA;

        if (bMinus)
            tempAnswer = 1.0/tempAnswer;

        if (aMinus && (b & 1) != 0)
            tempAnswer = tempAnswer * -1;

        return tempAnswer;

    }



    ///////////////////Good Solution///////////////////
    public double power2 (double x, int n) {
        if (n < 0) {
            return 1 / pow(x, -n);
        } else {
            return pow(x, n);
        }

    }

    private double pow(double x, int n) {
        if (n == 0)
            return 1;

        double v = pow(x, n/2);

        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }


    }


}
