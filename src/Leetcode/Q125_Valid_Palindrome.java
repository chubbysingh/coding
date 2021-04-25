package Leetcode;

/**
 * Given a string s, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
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

    public static void main(String[] args) {
        Q125_Valid_Palindrome sol = new Q125_Valid_Palindrome();
        boolean result = sol.isPalindrome("A man. a plan, a canal: Panama");

        System.out.println(result);

    }
}
