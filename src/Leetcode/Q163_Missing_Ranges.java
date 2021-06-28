package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbhatnagar2 on 3/15/17.
 * <p>
 * Given a sorted integer array where the range of elements are [0, 99] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], return [“2”, “4->49”, “51->74”, “76->100”]
 */
public class Q163_Missing_Ranges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(formatString(lower, upper));
            return result;
        }

        if (lower < nums[0]) {
            result.add(formatString(lower, nums[0] - 1));
        }

        for (int i = 1; i < nums.length; i++) {

            if (nums[i-1] + 1 != nums[i]) {
                result.add(formatString(nums[i-1] + 1, nums[i] - 1));
            }
        }

        if (upper > nums[nums.length - 1]) {
            result.add(formatString(nums[nums.length - 1] + 1, upper));
        }
        return result;

    }

    private String formatString(int lower, int upper) {
        if (lower == upper) return lower + "";
        return lower + "->" + upper;
    }

    public static void main(String[] args) {
        Q163_Missing_Ranges sol = new Q163_Missing_Ranges();
        int[] nums = {0, 1, 3, 50, 75};
        List<String> missingRange = sol.findMissingRanges(nums, 0, 100);
        System.out.println(missingRange);
    }
}
