package Leetcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis
 * that reflects the given points.

 Example 1:
 Given points = [[1,1],[-1,1]], return true.

 Example 2:
 Given points = [[1,1],[-1,-1]], return false.

 Follow up:
 Could you do better than O(n2)?

 Java Solution

 For this problem, we first find the smallest and largest x-value
 for all points and get the line's x-axis is (minX + maxX) / 2,
 then for each point, check if each point has a reflection points in the set.

 */
public class Q356_Line_Reflection {
    public boolean isReflected(int[][] points) {
        if(points==null || points.length<2)
            return true;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int[] arr: points){
            min = Math.min(min, arr[0]);
            max = Math.max(max, arr[0]);
            HashSet<Integer> set = map.get(arr[0]);
            if(set==null){
                set = new HashSet<Integer>();
                map.put(arr[0], set);
            }

            set.add(arr[1]);

        }

        int y = min+max;

        for(int[] arr: points){
            int left = arr[0];
            int right = y-left;
            if(map.get(right)==null || !map.get(right).contains(arr[1])){
                return false;
            }
        }

        return true;
    }

}
