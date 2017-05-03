package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q067_Add_Binary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuffer sb = new StringBuffer();

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            if (sum > 1) {
                carry = 1;
                sum = sum % 2;
            } else {
                carry = 0;
            }
            sb.append(String.valueOf(sum));

        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();

    }
}
