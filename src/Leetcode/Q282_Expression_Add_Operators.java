package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q282_Expression_Add_Operators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if (num == null || num.length() == 0) {
            return result;
        }

        addOperatorHelper(num, 0, target, 0, 0, "", result);

        return result;
    }

    private void addOperatorHelper(String num, int start, int target, long curSum,
                                   long preNum, String curResult, List<String> result) {
        if (start == num.length() ) {
            if (curSum == target) {
                result.add(curResult);
                return;
            }
        }

        for (int i = start; i < num.length(); i++) {
            String curStr = num.substring(start, i + 1);
            if (curStr.length() > 1 && curStr.charAt(0) == '0') {
                break;
            }

            long curNum = Long.parseLong(curStr);

            if (curResult.isEmpty()) {
                addOperatorHelper(num, i + 1, target, curNum, curNum, curStr, result);
            } else {
                // Add
                addOperatorHelper(num, i + 1, target, curSum + curNum, curNum,
                        curResult + "+" + curNum, result);

                // Subtract
                addOperatorHelper(num, i + 1, target, curSum - curNum, -curNum,
                        curResult + "-" + curNum, result);

                // Multiply
                addOperatorHelper(num, i + 1, target, curSum - preNum + preNum * curNum,
                        preNum * curNum, curResult + "*" + curNum, result);
            }
        }
    }
}
