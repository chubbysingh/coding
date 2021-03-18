package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q0008_String_to_Integer {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() < 1)
            return 0;

        boolean isNegative = false;
        int start = 0;
        if (str.charAt(0) == '-') {
            isNegative = true;
            start++;
        } else if (str.charAt(0) == '+') {
            start++;
        }


        double result = 0;
        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                result = result * 10 + (str.charAt(i) - '0');
            } else {
                break;
            }
        }

        if (isNegative)
            result = 0 - result;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int) result;

    }
}
