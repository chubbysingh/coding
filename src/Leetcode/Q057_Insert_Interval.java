package Leetcode;

import java.util.ArrayList;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q057_Insert_Interval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();

        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                result.add(interval);
            }

            else if (interval.start > newInterval.end) {
                result.add(newInterval);
                newInterval = interval;
            }

            else if (interval.end >= newInterval.start || interval.start <= newInterval.end) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }

        result.add(newInterval);
        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
