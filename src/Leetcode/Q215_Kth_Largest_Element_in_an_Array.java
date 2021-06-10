package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q215_Kth_Largest_Element_in_an_Array {

    /*
     * Min heap
     * Time: O(k)
     * Space: O(k)
     */
    public int findKthLargestMinHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    /*
     * Using Max Heap
     * Time: O(n) + O(k * logn)
     * Space: O(n)
     */
    public int findKthLargestMaxHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.offer(num);
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result = maxHeap.poll();
        }

        return result;
    }
}
