package Leetcode;

import java.util.Arrays;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q0556_Next_Greater_Element_III {
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();

        int i, j;
        // I) Start from the right most digit and
        // find the first digit that is
        // smaller than the digit next to it.
        for (i = number.length - 1; i > 0; i--)
            if (number[i - 1] < number[i])
                break;

        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;

        // II) Find the smallest digit on right side of (i-1)'th
        // digit that is greater than number[i-1]
        int x = number[i - 1], smallest = i;
        for (j = i + 1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;

        // III) Swap the above found smallest digit with
        // number[i-1]
        char temp = number[i - 1];
        number[i - 1] = number[smallest];
        number[smallest] = temp;

        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(number, i, number.length);

        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}
