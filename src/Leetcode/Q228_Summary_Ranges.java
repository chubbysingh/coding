package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q228_Summary_Ranges {
    public List<String> summaryRanges(int[] nums) {

        int length = nums.length;

        List<String> result = new ArrayList<String>(length);

        for (int i = 0; i < length; i++) {
            int start = nums[i];

            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                result.add(start + "->" + nums[i]);
            } else {
                result.add(start + "");
            }
        }

        return result;

    }
}
