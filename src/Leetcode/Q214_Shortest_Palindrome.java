package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q214_Shortest_Palindrome {

    public String shortestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }

        if (i == s.length())
            return s;

        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix + mid + suffix;
    }

    // Method Two

    public String shortestPalindromeTwo(String s) {
        if (s == null || s.length() <= 1)
            return s;

        String result = null;

        int len = s.length();
        int mid = len / 2;

        for (int i = mid; i >= 1; i--) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                if ((result = scanFromCenter(s, i - 1, i)) != null)
                    return result;
            } else {
                if ((result = scanFromCenter(s, i - 1, i - 1)) != null)
                    return result;
            }
        }

        return result;
    }

    private String scanFromCenter(String s, int l, int r) {
        int i = 1;

        //scan from center to both sides
        for (; l - i >= 0; i++) {
            if (s.charAt(l - i) != s.charAt(r + i))
                break;
        }

        //if not end at the beginning of s, return null
        if (l - i >= 0)
            return null;

        StringBuilder sb = new StringBuilder(s.substring(r + i));
        sb.reverse();

        return sb.append(s).toString();
    }
}
