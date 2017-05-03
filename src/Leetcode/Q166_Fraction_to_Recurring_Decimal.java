package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q166_Fraction_to_Recurring_Decimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder res = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0))
            res.append("-");

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        //integral part
        res.append(numerator / denominator);

        int num = numerator % denominator;
        if (num == 0)
            return res.toString();

        //decimal part
        res.append(".");

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(num, res.length());
        while (num != 0) {
            num = num * 10;
            res.append(num / denominator);
            num = num % denominator;
            if (map.containsKey(num)) {
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }

        }
        return res.toString();

    }

    public static void main(String[] args) {
        Q166_Fraction_to_Recurring_Decimal sol = new Q166_Fraction_to_Recurring_Decimal();
        String res = sol.fractionToDecimal(-1, -2147483648);
        System.out.println(res);
    }
}
