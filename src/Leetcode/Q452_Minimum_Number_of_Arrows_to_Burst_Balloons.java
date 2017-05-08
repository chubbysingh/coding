package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q452_Minimum_Number_of_Arrows_to_Burst_Balloons {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) return a[1] - b[1];
                else return a[0] - b[0];
            }
        });

        int minArrows = 1;
        int arrowLimit = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] baloon = points[i];
            if (baloon[0] <= arrowLimit) {
                arrowLimit = Math.min(arrowLimit, baloon[1]);
            } else {
                minArrows++;
                arrowLimit = baloon[1];
            }
        }
        return minArrows;
    }
}
