package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q278_First_Bad_Version {
    public int firstBadVersion(int n) {
        int start = 0, end = n;
        while (start < end) {
            if(isBadVersion(start))
                return start;

            int mid = start + (end-start)/2;
            if (isBadVersion(mid))
                end = mid;
            else
                start = mid+1;
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
