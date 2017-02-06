package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;

        while (low <= high) {
            long mid = low + (high-low)/2;

            if (mid*mid == num)
                return true;
            else if (mid*mid < num) {
                low = (int)mid + 1;
            } else {
                high = (int)mid - 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int i=1;

        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
