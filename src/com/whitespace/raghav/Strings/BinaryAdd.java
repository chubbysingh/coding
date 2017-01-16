package com.whitespace.raghav.Strings;

/**
 * Created by rbhatnagar2 on 12/10/15.
 *
 * Take binary expansions as strings,
 * and return the string containing their sum:
 *
 * add("10010", "101") = "10111"
 *
 */
public class BinaryAdd {
    public static String add(String a, String b) {
        if (a == null && b==null)
            return "0";
        if (a == null)
            return b;
        if (b == null)
            return a;

        int lengthA = a.length();
        int lengthB = b.length();

        StringBuffer result = new StringBuffer();
        int carry = 0;

        while (lengthA >= 0 && lengthB >= 0) {
            int sum = 0;
            if (lengthA >= 0) {
                sum += a.charAt(lengthA) - '0';
                lengthA--;
            }
            if (lengthB >= 0) {
                sum += b.charAt(lengthB) - '0';
            }

            carry = sum >> 1;
            sum = sum & 1;
            result.append( sum == 0 ? '0' : '1');

        }
        if (carry > 0)
            result.append('1');

        result.reverse();
        return result.toString();

    }
}
