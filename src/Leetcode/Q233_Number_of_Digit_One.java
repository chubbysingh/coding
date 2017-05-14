package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q233_Number_of_Digit_One {
    public int countDigitOne(int n) {
        int count = 0;
        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            // sum up the count of ones on every place k
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }
        return count;
    }
}
