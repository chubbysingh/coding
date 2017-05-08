package Leetcode;

/**
 * Created by rbhatnagar2 on 5/6/17.
 */
public class Q557_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        char[] cArr = s.toCharArray();

        int left = 0;
        for (int right = 0; right < cArr.length; right++) {
            if (cArr[right] == ' ') {
                reverse(cArr, left, right - 1);
                left = right + 1;
            }
        }
        reverse(cArr, left, cArr.length - 1);
        return new String(cArr);
    }

    private char[] reverse(char[] cArr, int start, int end) {
        while (start < end) {
            char t = cArr[start];
            cArr[start] = cArr[end];
            cArr[end] = t;
            start++;
            end--;
        }
        return cArr;
    }
}
