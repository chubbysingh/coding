package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q357_Count_Numbers_with_Unique_Digits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)     return 1;

        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }
}
