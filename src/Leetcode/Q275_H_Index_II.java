package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q275_H_Index_II {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = citations.length - 1;
        int len = citations.length;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (citations[mid] == len - mid) {
                return len - mid;
            } else if (citations[mid] < len - mid) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (citations[lo] >= len - lo) {
            return len - lo;
        }

        if (citations[hi] >= len - hi) {
            return len - hi;
        }

        return 0;
    }
}
