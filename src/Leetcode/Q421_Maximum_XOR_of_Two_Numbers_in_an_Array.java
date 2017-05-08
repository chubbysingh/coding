package Leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q421_Maximum_XOR_of_Two_Numbers_in_an_Array {
    /*
    This algorithm's idea is:
    to iteratively determine what would be each bit of the final result from left to right.
    And it narrows down the candidate group iteration by iteration.
    e.g. assume input are a,b,c,d,...z, 26 integers in total.
    In first iteration, if you found that a, d, e, h, u differs on the MSB(most significant bit),
    so you are sure your final result's MSB is set.
    Now in second iteration, you try to see if among a, d, e, h, u
    there are at least two numbers make the 2nd MSB differs,
    if yes, then definitely, the 2nd MSB will be set in the final result.
    And maybe at this point the candidate group shinks from a,d,e,h,u to a, e, h.
    Implicitly, every iteration, you are narrowing down the candidate group,
    but you don't need to track how the group is shrinking,
    you only cares about the final result.
     */
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
