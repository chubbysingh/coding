package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q394_Decode_String {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        char[] cs = s.toCharArray();
        int startNum = -1;
        int startString = -1;
        int bracketNums = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                if (startNum == -1) {
                    startNum = i;
                }
            } else if (cs[i] == '[') {
                if (startString == -1) {
                    startString = i;
                }
                bracketNums++;
            } else if (cs[i] == ']') {
                bracketNums--;
                if (bracketNums == 0) {
                    int times = Integer.valueOf(s.substring(startNum, startString));
                    String son = decodeString(s.substring(startString + 1, i));
                    for (int j = 0; j < times; j++) {
                        sb.append(son);
                    }
                    startString = -1;
                    startNum = -1;
                }
            } else if (bracketNums == 0) {
                sb.append(String.valueOf(cs[i]));
            }
        }
        return sb.toString();
    }
}
