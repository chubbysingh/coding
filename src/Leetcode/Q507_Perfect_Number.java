package Leetcode;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q507_Perfect_Number {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i + num / i;
            }
        }
        sum++;

        return sum == num;
    }
}
