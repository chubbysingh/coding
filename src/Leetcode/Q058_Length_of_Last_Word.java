package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q058_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        for (int i=s.length()-1 ; i >=0 ; i--) {
            if(s.charAt(i) == ' ') {
                return len;
            }
            len++;
        }
        return len;
    }
}
