package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 */
public class Q028_Implement_strStr {
    public int strStr(String haystack, String needle) {

        if (haystack == null || needle == null)
            return 0;

        else if (needle.length() == 0)
            return 0;

        else if (haystack.length() == needle.length() && haystack.equals(needle))
            return 0;

        //Loop through haystack
        for (int i=0; i < haystack.length() - needle.length() + 1; i++) {
            int indexH = i;
            // Loop through needle
            for (int j = 0; j < needle.length(); j++) {
                // If chars are same
                if (needle.charAt(j) == haystack.charAt(indexH)) {
                    // If we reach end of needle, return starting point i
                    if (j == needle.length()-1)
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
