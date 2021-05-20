package Leetcode;

import java.util.Random;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q398_Random_Pick_Index {
    Random rand;
    int[] nums;

    public Q398_Random_Pick_Index(int[] nums) {
        rand = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int count = 0;
        int idx = 0;
        for (int i = 0; i < this.nums.length; ++i) {
            // if nums[i] is equal to target, i is a potential candidate
            // which needs to be chosen uniformly at random
            if (this.nums[i] == target) {
                // increment the count of total candidates
                // available to be chosen uniformly at random
                count++;
                // we pick the current number with probability 1 / count (reservoir sampling)
                if (rand.nextInt(count) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}

/*

class Q398_Random_Pick_Index {

    private HashMap<Integer, List<Integer>> indices;
    private Random rand;

    public Solution(int[] nums) {
        this.rand = new Random();
        this.indices = new HashMap<Integer, List<Integer>>();
        int l = nums.length;
        for (int i = 0; i < l; ++i) {
            if (!this.indices.containsKey(nums[i])) {
                this.indices.put(nums[i], new ArrayList<>());
            }
            this.indices.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        int l = indices.get(target).size();
        // pick an index at random
        int randomIndex = indices.get(target).get(rand.nextInt(l));
        return randomIndex;
    }
}

 */
