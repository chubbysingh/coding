package Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...]
 * find the minimum number of conference rooms required.
 */

public class Q253_Meeting_Rooms_II {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 1;
        queue.offer(intervals[0].end);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                count++;

            } else {
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return count;
    }

    public int minMeetingRoomsTwo(Interval[] intervals) {
        int n=intervals.length;
        int[] start=new int[n];
        int[] end=new int[n];
        for (int i=0; i<n; i++) {
            start[i]=intervals[i].start;
            end[i]=intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0, j=0, res=0;
        while (i<n) {
            if (start[i]<end[j]) i++;
            else if (start[i]>end[j]) j++;
            else {
                i++;
                j++;
            }
            res=Math.max(res,i-j);
        }
        return res;
    }



    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
