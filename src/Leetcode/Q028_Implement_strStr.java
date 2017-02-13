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

        for (int i=0; i < haystack.length() - needle.length() + 1; i++) {
            int indexH = i;
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(indexH)) {
                    if (j == needle.length()-1)
                        return i;
                    else
                        indexH++;
                } else {
                    break;
                }

            }
        }
        return -1;
    }
}
