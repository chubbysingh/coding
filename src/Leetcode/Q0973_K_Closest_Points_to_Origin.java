package Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *
 *
 *
 */
public class Q0973_K_Closest_Points_to_Origin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        Q0973_K_Closest_Points_to_Origin sol = new Q0973_K_Closest_Points_to_Origin();
        int[][] nums = {{3, 3}, {5, -1}, {-2, 4}};

        int[][] result = sol.kClosest(nums, 2);
        System.out.println(Arrays.deepToString(result));

    }
}
