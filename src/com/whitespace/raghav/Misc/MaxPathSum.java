package com.whitespace.raghav.Misc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/30/17.
 * <p>
 * // arr[] = {1, 4, 5 , 2 , 3, 7}
 */
public class MaxPathSum {
    public int maxPathSum(int[] arr) {
        List<List<Integer>> listList = new LinkedList<List<Integer>>();

        //listList = buildList(arr);

        for (int i = listList.size() - 2; i >= 0; i--) {
            for (int j = 0; j < listList.get(i).size(); j++) {
                int value = listList.get(i).get(j);
                //listList.get(i).get(j) = listList.get(i).get(j)
                // + Math.max(listList.get(i+1).get(j), listList.get(i+1).get(j+1));
            }
        }
        return 0;
    }
}
