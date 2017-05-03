package Leetcode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q169_Majority_Element {
    public int majorityElement(int[] nums) {

        int majorityElement = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if (count == 0) {
                majorityElement = nums[i];
                count = 1;
            } else {
                if (majorityElement == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return majorityElement;

    }
}
