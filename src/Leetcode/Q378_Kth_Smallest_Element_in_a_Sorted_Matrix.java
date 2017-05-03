package Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 */
public class Q378_Kth_Smallest_Element_in_a_Sorted_Matrix {

    /*
     * We remove the smallest number and
     * offer the next smallest number k-1 times
     * After k-1, the min in the minHeap would be kth smallest element
     */
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();

        int n = matrix.length;

        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Tuple(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.x == matrix[0].length - 1)
                continue;
            else
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int val;

        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.val - that.val;
        }

    }


    /*
     * This method does not utilize the fact that
     * the matrix is sorted
     */
    public int kthSmallestBad(int[][] matrix, int k) {
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue(k, Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
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
