package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 */
public class Q271_Encode_and_Decode_Strings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();

        for (String str : strs) {
            if (str == null || str.length() == 0) {
                sb.append("0#");
            } else {
                sb.append(str.length() + "#" + str);
            }
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return strs;
        }

        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && Character.isDigit(s.charAt(j))) {
                j++;
            }

            int num = Integer.parseInt(s.substring(i, j));
            i = j;
            i++; // skip '#'
            if (num == 0) {
                strs.add("");
            } else {
                strs.add(s.substring(i, i + num));
            }

            i += num;
        }

        return strs;
    }
}
