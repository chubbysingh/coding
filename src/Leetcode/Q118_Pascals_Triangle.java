package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * https://leetcode.com/problems/pascals-triangle/
 */
public class Q118_Pascals_Triangle {
    public List<List<Integer>> generate(int nRows) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();

        for (int i = 0; i < nRows; i++) {
            List<Integer> rows = new LinkedList<Integer>();

            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    rows.add(1);
                } else {
                    int num = res.get(i - 1).get(j - 1)
                            + res.get(i - 1).get(j);
                    rows.add(num);
                }

            }
            res.add(rows);
        }
        return res;
    }
}
