package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q274_H_Index {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Step 1: Accmulate the number of citations for each bucket
        for (int i = 0; i < n; i++) {
            if (citations[i] <= n) {
                buckets[citations[i]]++;
            } else {
                buckets[n]++;
            }
        }

        // Step 2: iterate the citations from right to left.
        int numPapers = 0;
        for (int i = n; i >= 0; i--) {
            numPapers += buckets[i];
            if (numPapers >= i) {
                return i;
            }
        }

        return 0;
    }
}
