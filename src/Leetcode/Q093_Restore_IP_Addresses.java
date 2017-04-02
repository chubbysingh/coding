package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q093_Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();

        if (s == null || s.length() < 4)
            return result;

        restoreHelper(s, 0, 1, "", result);

        return result;
    }

    private void restoreHelper(String s, int start, int segment, String curr, List<String> result) {
        if (start >= s.length())
            return;

        if (segment == 4) {
            String temp = s.substring(start);
            if (isValid(temp)) {
                result.add(curr + "." + temp);
            }
            return;
        }

        for (int i = 1; i < 4 && start + i < s.length(); i++) {
            String temp = s.substring(start, start + i);
            if (isValid(temp)) {
                if (segment == 1) {
                    restoreHelper(s, start + i, segment + 1, temp, result);
                } else {
                    restoreHelper(s, start + i, segment + 1, curr + "." + temp, result);
                }
            }
        }
    }

    private boolean isValid(String str) {
        if (str == null || str.length() > 3) {
            return false;
        }

        int num = Integer.parseInt(str);
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }

        if (num >= 0 && num <= 255) {
            return true;
        }

        return false;
    }
}
