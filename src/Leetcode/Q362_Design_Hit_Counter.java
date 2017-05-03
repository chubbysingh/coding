package Leetcode;

import java.util.ArrayDeque;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Design a hit counter which counts the number of hits received in the past 5 minutes.
 Each function accepts a timestamp parameter (in seconds granularity)
 and you may assume that calls are being made to the system in chronological order
 (ie, the timestamp is monotonically increasing).

 You may assume that the earliest timestamp starts at 1.
 It is possible that several hits arrive roughly at the same time.
 * Example:
 HitCounter counter = new HitCounter();

 // hit at timestamp 1.
 counter.hit(1);

 // hit at timestamp 2.
 counter.hit(2);

 // hit at timestamp 3.
 counter.hit(3);

 // get hits at timestamp 4, should return 3.
 counter.getHits(4);

 // hit at timestamp 300.
 counter.hit(300);

 // get hits at timestamp 300, should return 4.
 counter.getHits(300);

 // get hits at timestamp 301, should return 3.
 counter.getHits(301);
 */
public class Q362_Design_Hit_Counter {
    private ArrayDeque<Integer> memory;
    /** Initialize your data structure here. */
    public Q362_Design_Hit_Counter() {
        memory = new ArrayDeque<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        memory.add(timestamp);
        // int top = memory.poll();
        // while (timestamp - top >= 300) {
        //     top = memory.poll();
        // }
        // memory.addFirst(top);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (!memory.isEmpty()) {
            while (!memory.isEmpty() && (timestamp - memory.peek()) >= 300) {
                memory.poll();
            }
        }
        return memory.size();
    }
}
