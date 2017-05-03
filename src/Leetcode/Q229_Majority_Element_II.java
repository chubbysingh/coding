package Leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();

        if (nums == null || nums.length == 0)
            return result;

        int number1 = nums[0], number2 = nums[0],
                count1 = 0, count2 = 0;

        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] == number1)
                count1++;
            else if (nums[i] == number2)
                count2++;
            else if (count1 == 0) {
                number1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                number2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }


        }

        count1 = 0;
        count2 = 0;

        for (int n : nums) {
            if (n == number1)
                count1++;
            else if (n == number2)
                count2++;
        }

        if (count1 > length / 3)
            result.add(number1);
        if (count2 > length / 3)
            result.add(number2);

        return result;
    }
}
