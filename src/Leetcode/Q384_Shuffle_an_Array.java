package Leetcode;

import java.util.Random;

/**
 * Created by rbhatnagar2 on 1/15/17.
 *
 * Shuffle a set of numbers without duplicates.
 *
 */
public class Q384_Shuffle_an_Array {
    private int[] nums;
    private Random random;

    public Q384_Shuffle_an_Array(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null)
            return nums;

        int[] a = nums.clone();
        for (int i=0; i<a.length; i++) {
            int r = random.nextInt(i+1);
            swap(a, i, r);
        }
        return a;
    }
    private void swap(int[] a, int i, int random) {
        int temp = a[i];
        a[i] = a[random];
        a[random] = temp;
    }
}
