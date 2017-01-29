package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q476_Number_Complement {
    public int findComplement(int num) {
        return num ^ (highestOneBit(num) - 1);
    }

    private int highestOneBit(int num) {
        int res = 1;

        while (num > 0) {
            res = res << 1;
            num = num >> 1;
        }
        return res;
    }
}
