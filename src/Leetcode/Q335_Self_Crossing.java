package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q335_Self_Crossing {

    //http://buttercola.blogspot.com/2016/06/leetcode-335-self-crossing.html
    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length <= 3) {
            return false;
        }

        int i = 2;
        int len = x.length;

        // case 1: outside squrial
        while (i < len && x[i] > x[i - 2]) {
            i++;
        }

        if (i == len) {
            return false;
        }

        // case 2: transist to inside squrial
        if ((i >= 4 && x[i] + x[i - 4] >= x[i - 2]) ||
                (i == 3 && x[i] == x[i - 2])) {
            x[i - 1] -= x[i - 3];
        }
        i++;

        // case 3: inside squrial
        while (i < len && x[i] < x[i - 2]) {
            i++;
        }

        return i != len;
    }
}
