package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q057_Insert_Interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<>();

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

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return "{" + start + "," + end + '}';
        }
    }

    public static void main(String[] args) {
        Q057_Insert_Interval sol = new Q057_Insert_Interval();

        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(6, 9)
        );

        Interval newInternal = new Interval(2, 5);

        List<Interval> result = sol.insert(intervals, newInternal);

        System.out.println(result);
    }
}
