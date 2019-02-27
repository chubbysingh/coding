package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 * <p>
 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
 */

public class Q252_Meeting_Rooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        /*
        Other ways:

        Arrays.sort(intervals, (a, b) -> a.start - b.start);

        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
         */

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }

        return true;
    }

    class Interval {
        int start;
        int end;
    }
}
