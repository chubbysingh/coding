package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 */

public class Q346_Moving_Average_from_Data_Stream {
    Queue<Integer> queue;
    int size;
    double avg;

    /**
     * Initialize your data structure here.
     */
    public Q346_Moving_Average_from_Data_Stream(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() < this.size) {
            queue.offer(val);
            int sum = 0;
            for (int i : queue) {
                sum += i;
            }
            avg = (double) sum / queue.size();

            return avg;
        } else {
            int head = queue.poll();
            double minus = (double) head / this.size;
            queue.offer(val);
            double add = (double) val / this.size;
            avg = avg + add - minus;
            return avg;
        }
    }
}
