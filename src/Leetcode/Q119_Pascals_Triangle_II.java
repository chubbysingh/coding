package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 */
public class Q119_Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            result.add(1);
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}
