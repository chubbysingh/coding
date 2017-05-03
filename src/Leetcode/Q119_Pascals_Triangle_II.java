package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 * <p>
 * Given an index k, return the kth row of the Pascal's triangle.
 */
public class Q119_Pascals_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i <= rowIndex; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Q119_Pascals_Triangle_II sol = new Q119_Pascals_Triangle_II();
        int k = 3;
        List<Integer> result = sol.getRow(k);
        System.out.println(result);
    }
}
