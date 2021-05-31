package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q057_New_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            }

            else if (newInterval[1] < interval[0]) {
                result.add(newInterval);
                newInterval = interval;
            }

            else {
                newInterval = new int[] { Math.min(interval[0], newInterval[0]),
                        Math.max(newInterval[1], interval[1])
                };
            }
        }

        result.add(newInterval);

        int[][] resultArr = new int[result.size()][2];

        for (int i=0; i < resultArr.length; i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    public static void main(String[] args) {
        Q057_New_Insert_Interval sol = new Q057_New_Insert_Interval();

        int[][] intervals = new int[][] {
                {1, 3}, {6, 9}
        };

        int[] newInternal = new int[] {2, 5};

        int[][] result = sol.insert(intervals, newInternal);

        System.out.println(Arrays.deepToString(result));
    }
}
