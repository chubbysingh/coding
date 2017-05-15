package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 * Each function accepts a timestamp parameter (in seconds granularity)
 * and you may assume that calls are being made to the system in chronological order
 * (ie, the timestamp is monotonically increasing).
 * <p>
 * You may assume that the earliest timestamp starts at 1.
 * It is possible that several hits arrive roughly at the same time.
 * Example:
 * HitCounter counter = new HitCounter();
 * <p>
 * // hit at timestamp 1.
 * counter.hit(1);
 * <p>
 * // hit at timestamp 2.
 * counter.hit(2);
 * <p>
 * // hit at timestamp 3.
 * counter.hit(3);
 * <p>
 * // get hits at timestamp 4, should return 3.
 * counter.getHits(4);
 * <p>
 * // hit at timestamp 300.
 * counter.hit(300);
 * <p>
 * // get hits at timestamp 300, should return 4.
 * counter.getHits(300);
 * <p>
 * // get hits at timestamp 301, should return 3.
 * counter.getHits(301);
 */
public class Q362_Design_Hit_Counter {
    private Queue<Integer> queue = new LinkedList<Integer>();

    /**
     * Initialize your data structure here.
     */
    public Q362_Design_Hit_Counter() {
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        queue.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        if (!queue.isEmpty()) {
            while (!queue.isEmpty() && (timestamp - queue.peek()) >= 300) {
                queue.poll();
            }
        }
        return queue.size();
    }
}
