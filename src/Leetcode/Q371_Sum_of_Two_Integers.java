package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q371_Sum_of_Two_Integers {
    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = a & b;
            a = a ^ b; // sum
            b = carry << 1;
        }
        return a;
    }
}
