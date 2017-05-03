package Leetcode;

/**
 * Created by rbhatnagar2 on 1/12/17.
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 */
public class Q004_Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        // Even. Then median is n/2 and n/2 + 1
        if (totalLength % 2 == 0) {
            return (findKth(totalLength / 2, nums1, nums2, 0, 0)
                    + findKth(totalLength / 2 + 1, nums1, nums2, 0, 0)) / 2.0;
        }
        // Odd. The median is n/2+1
        else {
            return findKth(totalLength / 2 + 1, nums1, nums2, 0, 0);
        }
    }

    public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
        if (s1 >= nums1.length)
            return nums2[s2 + k - 1];

        if (s2 >= nums2.length)
            return nums1[s1 + k - 1];

        if (k == 1)
            return Math.min(nums1[s1], nums2[s2]);

        int m1 = s1 + k / 2 - 1;
        int m2 = s2 + k / 2 - 1;

        int mid1 = m1 < nums1.length ? nums1[m1] : Integer.MAX_VALUE;
        int mid2 = m2 < nums2.length ? nums2[m2] : Integer.MAX_VALUE;

        if (mid1 < mid2) {
            return findKth(k - k / 2, nums1, nums2, m1 + 1, s2);
        } else {
            return findKth(k - k / 2, nums1, nums2, s1, m2 + 1);
        }
    }
}
