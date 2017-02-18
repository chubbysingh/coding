package Leetcode;

/**
 * Created by rbhatnagar2 on 2/13/17.
 */
public class Q504_Base_7 {
    public String convertToBase7(int num) {
        if (num == 0)
            return "0";

        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        if (num < 0) {
            negative = true;
            num *= -1;
        }
        while (num != 0) {
            sb.append(num % 7);
            num = num / 7;
        }

        if (negative) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }
}
