package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q215_Kth_Largest_Element_in_an_Array {


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

    /*
     * Min heap
     * Time: O(k)
     * Space: O(k)
     */
    public int findKthLargestMinHeap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);

        for (int num : nums) {

            // Put 1st k elements in the heap
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            }
            // if incoming number > min, add that number in the heap
            else {
                if (num > maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(num);
                }
            }
        }
        // result will be k largest numbers with min as kth largest number
        return maxHeap.peek();
    }
}
