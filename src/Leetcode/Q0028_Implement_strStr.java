package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 * What should we return when needle is an empty string?
 * This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf().
 *
 */
public class Q0028_Implement_strStr {
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null)
            return 0;

        else if (needle.length() == 0)
            return 0;

        else if (haystack.length() == needle.length() && haystack.equals(needle))
            return 0;

        //Loop through haystack
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int indexH = i;
            // Loop through needle
            for (int j = 0; j < needle.length(); j++) {
                // If chars are same
                if (needle.charAt(j) == haystack.charAt(indexH)) {
                    // If we reach end of needle, return starting point i
                    if (j == needle.length() - 1)
                        return i;
                        // Run the inner loop for next char
                    else
                        indexH++;
                }
                // If chars are not same, break the inner loop
                else {
                    break;
                }

            }
        }
        return -1;
    }
}
