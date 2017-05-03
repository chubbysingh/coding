package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q202_Happy_Number {
    //  until the number equals 1 (where it will stay), or it loops endlessly in a cycle
    Set<Integer> _set = new HashSet<Integer>();

    public boolean isHappy(int n) {

        while (n != 1) {
            if (!_set.contains(n)) {
                _set.add(n);

                n = getSum(n);
            } else {
                return false;
            }
        }
        return true;
    }

    private int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;

    }
}
