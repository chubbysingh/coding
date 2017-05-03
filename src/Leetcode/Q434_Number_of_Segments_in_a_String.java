package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q434_Number_of_Segments_in_a_String {
    public int countSegments(String s) {
        if (s == null || s.trim().length() == 0)
            return 0;

        int count = 1;
        for (int i = 0; i < s.trim().length() - 1; i++) {
            if (s.charAt(i) != ' ' && s.charAt(i + 1) == ' ')
                count++;
        }
        return count;
    }
}
