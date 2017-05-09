package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q335_Self_Crossing {

    //http://www.programcreek.com/2015/03/leetcode-self-crossing-java/
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length <= 3)
            return false;

        for (int i = 3; i < x.length; i++) {
            if (x[i - 3] >= x[i - 1] && x[i - 2] <= x[i]) {
                return true;
            }

            if (i >= 4 && x[i - 4] + x[i] >= x[i - 2] && x[i - 3] == x[i - 1]) {
                return true;
            }

            if (i >= 5 && x[i - 5] <= x[i - 3] && x[i] <= x[i - 2] && x[i - 1] <= x[i - 3] && x[i - 4] <= x[i - 2] && x[i - 1] >= x[i - 3] - x[i - 5] && x[i] >= x[i - 2] - x[i - 4]) {
                return true;
            }
        }

        return false;
    }
}
