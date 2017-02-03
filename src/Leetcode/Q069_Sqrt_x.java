package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q069_Sqrt_x {
    public int mySqrt(int x) {

        if (x == 0)
            return 0;
        else if (x < 1) {
            return 1 / mySqrt(1/x) ;
        }
        else if (x == 1)
            return 1;

        int left = 1, right = x;
        while (left < right) {
            int mid = left + (right-left)/2;

            if (mid == x/mid) {
                return mid;
            }
            else if (mid > x/mid) {
                right = mid;
            } else {
                if (mid+1 > (x/(mid+1))) {
                    return mid;
                }
                left = mid+1;
            }
        }
        return -1;
    }
}
