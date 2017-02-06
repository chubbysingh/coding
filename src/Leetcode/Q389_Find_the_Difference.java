package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q389_Find_the_Difference {
    public char findTheDifference(String s, String t) {

        int charCountS= 0, charCountT = 0;
        for(char c : s.toCharArray()) {
            charCountS += (int) c ;
        }
        for(char c : t.toCharArray()) {
            charCountT += (int) c ;
        }

        return (char) (charCountT - charCountS);
    }
}
