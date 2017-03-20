package Leetcode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int currentIndex = m + n - 1,
                index1 = m-1,
                index2 = n-1;

        while (index1 >= 0 || index2 >= 0) {
            int first = Integer.MIN_VALUE,
                    second = Integer.MIN_VALUE;

            if (index1 >= 0) {
                first = nums1[index1];
            }
            if (index2 >= 0) {
                second = nums2[index2];
            }

            if (first > second) {
                nums1[currentIndex] = first;
                index1--;
            } else {
                nums1[currentIndex] = second;
                index2--;
            }
            currentIndex--;
        }
    }
}
