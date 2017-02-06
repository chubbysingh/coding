package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null)
            return true;
        else if (s == null || t == null)
            return false;
        else if (s.length() != t.length())
            return false;
        else {
            int[] countArr = new int[26];

            for (int i=0; i< s.length(); i++) {
                countArr[s.charAt(i) - 'a']++;
                countArr[t.charAt(i) - 'a']--;
            }

            for (int i=0; i< countArr.length; i++) {
                if (countArr[i] != 0)
                    return false;
            }
            return true;
        }
    }
}
