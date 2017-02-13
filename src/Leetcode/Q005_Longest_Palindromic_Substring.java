package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * 
 */
public class Q005_Longest_Palindromic_Substring {
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();

        int lo=0, result=0;
        for (int i=0; i<ch.length; i++) {
            int x=i, y=i+1, palindrome=0;
            while (x >=0 && y < ch.length && ch[x] == ch[y]) {
                x--;
                y++;
                palindrome += 2;
            }
            if(palindrome > result) {
                result = palindrome; lo=x;
            }

            x = i-1; y=i+1; palindrome=1;
            while (x >=0 && y<ch.length && ch[x] == ch[y]) {
                x--; y++; palindrome+=2;
            }
            if(palindrome > result) {
                result = palindrome; lo=x;
            }
        }
        return s.substring(lo+1, lo+result+1);

    }
}
