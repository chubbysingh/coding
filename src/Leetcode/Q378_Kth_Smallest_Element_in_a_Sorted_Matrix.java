package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue(k, Collections.reverseOrder());
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                } else {
                    int temp = pq.peek();
                    if (temp > matrix[i][j]) {
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.poll();
    }
}
