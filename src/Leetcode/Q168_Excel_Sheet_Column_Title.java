package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q168_Excel_Sheet_Column_Title {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n > 0) {
            n--;
            Character c = (char) ('A' + n%26);
            n /= 26;
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
