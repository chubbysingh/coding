package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * <p>
 * Given four lists A, B, C, D of integer values,
 * compute how many tuples (i, j, k, l) there are such that
 * A[i] + B[j] + C[k] + D[l] is zero.
 */
public class Q454_4Sum_II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : C) {
            for (int j : D) {
                int sum = i + j;
                //Map : sum -> occurance
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }

        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                // we need to find 0-sum from map so that result is zero
                int sumToFindInMap = 0 - sum;
                if (map.containsKey(sumToFindInMap))
                    result += map.get(sumToFindInMap);
            }
        }
        return result;
    }
}
