package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q278_First_Bad_Version {
    public int firstBadVersion(int n) {
        return binarySearchBadVersion(0, n);
    }

    private int binarySearchBadVersion(int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }

            if (isBadVersion(start)) {
                return start;
            }
        }
        return end;

    }

    /**
     * Given API
     *
     * @param version
     * @return
     */
    public boolean isBadVersion(int version) {
        return false;
    }
}
