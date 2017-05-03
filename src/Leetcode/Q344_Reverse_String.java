package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q344_Reverse_String {
    public String reverseString(String s) {
        if (s == null || s.length() < 2)
            return s;

        char[] strArray = s.toCharArray();

        int start = 0;
        int end = strArray.length - 1;

        while (start < end) {
            char temp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = temp;
            start++;
            end--;

        }
        return new String(strArray);
    }
}
