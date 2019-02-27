package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 */
public class Q242_Valid_Anagram {

    // Method 1 : Sort and compare
    // Time: O(nlog(n)) Space: O(1)

    // Method 2: Use HashMap to add count of chars of s and compare with t
    // Time: O(n) Space: O(n)

    //Method 3
    // Time: O(n) Space: O(1)
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;

        else if (s == null || t == null)
            return false;

        else if (s.length() != t.length())
            return false;

        else {
            int[] countArr = new int[26];

            for (int i = 0; i < s.length(); i++) {
                countArr[s.charAt(i) - 'a']++;
                countArr[t.charAt(i) - 'a']--;
            }

            for (int i = 0; i < countArr.length; i++) {
                if (countArr[i] != 0)
                    return false;
            }
            return true;
        }
    }
}
