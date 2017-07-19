package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->100”]
 */
public class Q163_Missing_Ranges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            list.add(rangeToString(lower, upper));
            return list;
        }

        Arrays.sort(nums);

        int pre = lower - 1;
        for (int n : nums) {
            if (n - pre > 1)
                list.add(rangeToString(pre + 1, n - 1));

            pre = n;
        }

        if (pre + 1 <= upper)
            list.add(rangeToString(pre + 1, upper));

        return list;
    }

    private String rangeToString(long l, long r) {
        if (l == r) return "" + l;
        else return l + "->" + r;
    }

    public static void main(String[] args) {
        Q163_Missing_Ranges sol = new Q163_Missing_Ranges();
        int[] nums = {0, 1, 3, 50, 75};
        List<String> missingRange = sol.findMissingRanges(nums, 0, 100);
        System.out.println(missingRange);
    }
}
