package Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 Note:
 The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

 Example 1:
 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 */

public class Q325_Maximum_Size_Subarray_Sum_Equals_k {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = 0;

        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum==k){
                max = Math.max(max, i+1);
            }

            int diff = sum-k;

            if(map.containsKey(diff)){
                max = Math.max(max, i-map.get(diff));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }


        return max;
    }
}
