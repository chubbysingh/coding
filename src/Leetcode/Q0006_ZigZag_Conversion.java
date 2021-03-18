package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class Q0006_ZigZag_Conversion {
    public String convert(String text, int nRows) {
        StringBuilder[] sbArr = new StringBuilder[nRows];

        for (int i = 0; i < nRows; i++) {
            sbArr[i] = new StringBuilder();
        }

        int index = 0;
        boolean isGoingDown = true;

        for (char c : text.toCharArray()) {
            sbArr[index].append(c);
            if (isGoingDown) {
                index++;

                if (index == nRows) {
                    index -= 2;
                    isGoingDown = false;
                }
            } else {
                index--;

                if (index < 0) {
                    index += 2;
                    isGoingDown = true;
                }
            }
        }

        for (int i = 1; i < nRows; i++) {
            sbArr[0].append(sbArr[i]);
        }
        return sbArr[0].toString();
    }
}
