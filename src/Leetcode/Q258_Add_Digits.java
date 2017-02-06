package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q258_Add_Digits {
    public int addDigits(int num) {
        if (num < 10)
            return num;

        int result = 0;
        while(num > 0) {
            result += num%10;
            num /= 10;
        }
        return addDigits(result);
    }
}
