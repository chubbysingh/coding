package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q012_Integer_to_Roman {
    public String intToRoman(int num) {
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] key = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                String curVal = key[i];
                sb.append(curVal);
                num -= val[i];
            }
        }
        return sb.toString();
    }
}
