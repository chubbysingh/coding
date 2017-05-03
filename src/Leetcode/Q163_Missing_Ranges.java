package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 *
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->99”]

 */
public class Q163_Missing_Ranges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        class Helper {
            public String rangeToString(long l, long r) {
                if (l == r) return "" + l;
                else return l + "->" + r;
            }
        }
        Helper helper = new Helper();

        List<String> list = new ArrayList<>();
        if (nums == null || nums.length <= 0) list.add(helper.rangeToString(lower, upper));
        else {
            Arrays.sort(nums);
            long pre = lower - 1L;
            for (int i = 0; i < nums.length; pre = nums[i], i++)
                if (nums[i] - pre >= 2) list.add(helper.rangeToString(pre + 1L, nums[i] - 1L));
            if (pre + 1L <= upper) list.add(helper.rangeToString(pre + 1L, upper));
        }
        return list;
    }
}
