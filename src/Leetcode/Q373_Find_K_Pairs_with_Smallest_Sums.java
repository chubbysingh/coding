package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q373_Find_K_Pairs_with_Smallest_Sums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();

        k = Math.min(k, nums1.length*nums2.length);

        if(k==0)
            return result;

        int[] idx = new int[nums1.length];

        while(k>0){
            int min = Integer.MAX_VALUE;
            int t=0;
            for(int i=0; i<nums1.length; i++){
                if(idx[i]<nums2.length && nums1[i]+nums2[idx[i]]<min){
                    t=i;
                    min = nums1[i]+nums2[idx[i]];
                }
            }

            int[] arr = {nums1[t], nums2[idx[t]]};
            result.add(arr);

            idx[t]++;

            k--;
        }

        return result;
    }
}
