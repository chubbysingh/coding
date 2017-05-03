package Leetcode;

import Leetcode.Util.TreeNode;

/**
 * Created by rbhatnagar2 on 1/15/17.
 */
public class Q124_Binary_Tree_Maximum_Path_Sum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        int arch = left + right + root.val;

        int pathSum = Math.max(root.val, Math.max(left, right) + root.val);

        maxSum = Math.max(maxSum, Math.max(arch, pathSum));

        return pathSum;
    }
}
