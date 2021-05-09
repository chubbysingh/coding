package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/13/17.
 */
public class Q108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;

        TreeNode result = helper(nums, 0, nums.length - 1);
        return result;
    }

    private TreeNode helper(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = helper(nums, low, mid - 1);
        curr.right = helper(nums, mid + 1, high);
        return curr;
    }
}
