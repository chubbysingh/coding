package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start < end) {
            if (isNotLetter(s.charAt(start)))
                start++;
            else if (isNotLetter(s.charAt(end)))
                end--;
            else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                    return false;
                else {
                    start++;
                    end--;
                }
            }

        }
        return true;
    }

    private boolean isNotLetter(Character c) {
        return !((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'));
    }
}
