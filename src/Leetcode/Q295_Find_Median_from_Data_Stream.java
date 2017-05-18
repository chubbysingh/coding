package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q295_Find_Median_from_Data_Stream {
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;

    /**
     * initialize your data structure here.
     */
    public Q295_Find_Median_from_Data_Stream() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
    }

    /*
    Use two heaps.
    The maxHeap stores the number which is less than the current number.
    The minHeap stores the number which is greter than the current number.
    We also need to keep the two heaps balanced in size.
    */
    public void addNum(int num) {
        maxPq.offer(num);
        minPq.offer(maxPq.poll());
        if (maxPq.size() < minPq.size()){
            maxPq.offer(minPq.poll());
        }
    }
    /*
    For the method findMedian(), we need to check if the two heaps have the same size.
    If yes, there must be even number of elements so far,
    so the median is the average of the top of the minHeap and the maxHeap.
    If not, i.e. odd number of elements so far,
    the median is the top of the heap which one more element.
    */
    public double findMedian() {
        if (maxPq.size() == minPq.size()) return (maxPq.peek() + minPq.peek()) /  2.0;
        else return maxPq.peek();
    }
}
