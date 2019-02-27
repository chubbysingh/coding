package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 */
public class Q058_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return len;
            }
            len++;
        }
        return len;
    }

    /**
     * special handling for cases like "chubby singh  " (end in a space)
     */

    public int lengthOfLastWordWithoutTrim(String s) {
        if(s==null || s.length() == 0)
            return 0;

        int result = 0;
        int len = s.length();

        boolean flag = false;
        for(int i=len-1; i>=0; i--){
            char c = s.charAt(i);
            if((c>='a' && c<='z') || (c>='A' && c<='Z')){
                flag = true;
                result++;
            }else{
                if(flag)
                    return result;
            }
        }

        return result;
    }
}
