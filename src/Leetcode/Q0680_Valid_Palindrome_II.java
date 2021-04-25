package Leetcode;

/**
 * Given a non-empty string s,
 * you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Q0680_Valid_Palindrome_II {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start+1, end)
                        || isPalindrome(s, start, end-1);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q0680_Valid_Palindrome_II sol = new Q0680_Valid_Palindrome_II();
        System.out.println(sol.validPalindrome("abca"));
    }
}
