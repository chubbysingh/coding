package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q295_Find_Median_from_Data_Stream {
    PriorityQueue<Integer> small; // Max Heap to fetch the maximum number in O(1)
    PriorityQueue<Integer> large; // Min Heap to fetch the minimum number in O(1)
    boolean isEven;

    /**
     * initialize your data structure here.
     */
    public Q295_Find_Median_from_Data_Stream() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
        isEven = true;
    }

    /*
    Use two heaps.
    Always make large Heap larger if need be.
    While inserting, pick the brightest kid from other section.
    */
    public void addNum(int num) {
        if (isEven) {
            // Put in large heap. Pick the brightest kid from small heap
            small.offer(num);
            large.offer(small.poll());
        } else {
            // Put in small heap. Pick the brightest kid from large heap
            large.offer(num);
            small.offer(large.poll());
        }
        isEven = !isEven;
    }
    /*
    For the method findMedian(), we need to check if the two heaps have the same size.
    If yes, there must be even number of elements so far,
    so the median is the average of the top of the minHeap and the maxHeap.
    If not, i.e. odd number of elements so far,
    the median is the top of the heap which one more element.
    */
    public double findMedian() {
        if (isEven) {
            return (large.peek() + small.peek()) / 2.0; //2.0 as we need to return a double
        } else {
            return large.peek();
        }
    }
}
