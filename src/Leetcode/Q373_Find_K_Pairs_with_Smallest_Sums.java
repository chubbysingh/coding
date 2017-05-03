package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q373_Find_K_Pairs_with_Smallest_Sums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<int[]> res = new LinkedList<int[]>();
        PriorityQueue<Tuple> queue = new PriorityQueue<Tuple>();

        if(nums1.length==0 || nums2.length==0 || k==0)
            return res;

        for(int i=0; i<nums1.length && i<k; i++)
            queue.offer(new Tuple(nums1[i], nums2[0], 0));

        while(k > 0 && !queue.isEmpty()){
            k--;
            Tuple tuple = queue.poll();
            res.add(new int[]{tuple.num1, tuple.num2});

            if(tuple.num2Index == nums2.length-1)
                continue;

            queue.offer(new Tuple(tuple.num1, nums2[tuple.num2Index+1], tuple.num2Index+1));


        }
        return res;
    }

    class Tuple implements Comparable<Tuple>{
        int num1, num2, num2Index;

        public Tuple(int num1, int num2, int num2Index) {
            this.num1 = num1;
            this.num2 = num2;
            this.num2Index = num2Index;
        }

        @Override
        public int compareTo(Tuple that) {
            return this.num1 + this.num2 - that.num1 - that.num2;
        }
    }
}
